const canvas = document.querySelector('canvas');
const c = canvas.getContext('2d');

canvas.width = 1024;
canvas.height = 576;
//canvas.width = innerWidth;
//canvas.height = innerHeight;

let width;

class Player {
  constructor() {

    this.velocity = {
      x: 0,
      y: 0
    }

    this.rotation = 0;
    this.opacity = 1;

    const image = new Image();
    image.src = './player.png';
    image.onload = () => {
      console.log('image load player');
      const scale = 0.1;
      this.image = image;
      this.width = image.width * scale;
      this.height = image.height * scale;
      this.position = {
        x: canvas.width / 2 - this.width / 2,
        y: canvas.height - this.height - 20
      }
    }
    
  }

  draw() {
    // c.fillStyle = 'red';
    // c.fillRect(this.position.x, this.position.y, this.width,
    //   this.height);
    c.save();
    c.globalAlpha = this.opacity
    c.translate(player.position.x + player.width/2,
     player.position.y + player.height/2);
    c.rotate(this.rotation);

    c.translate(-player.position.x - player.width/2,
     -player.position.y - player.height/2);

    c.drawImage(this.image, this.position.x, this.position.y,
      this.width, this.height);
    
    c.restore();
  }

  update() {
    if(this.image) {
      this.draw();
      this.position.x += this.velocity.x;
    }
  }
}

class Particle {
  constructor({position, velocity, radius, color, fades}) {
    this.position = position;
    this.velocity = velocity;

    this.radius = radius;
    this.color = color
    this.opacity = 1
    this.fades = fades
  }

  draw() {
	c.save()
	c.globalAlpha = this.opacity
    c.beginPath();
    c.arc(this.position.x, this.position.y, this.radius, 
      0, Math.PI * 2);
    
    c.fillStyle = this.color;
    c.fill();
    c.closePath();
    c.restore()
  }

  update() {
    this.draw();
    this.position.x += this.velocity.x;
    this.position.y += this.velocity.y;
    
    if(this.fades) this.opacity -= 0.01
  }
}

class Projectile {
  constructor({position, velocity}) {
    this.position = position;
    this.velocity = velocity;

    this.radius = 3;
  }

  draw() {
    c.beginPath();
    c.arc(this.position.x, this.position.y, this.radius, 
      0, Math.PI * 2);
    
    c.fillStyle = 'blue';
    c.fill();
    c.closePath();
  }

  update() {
    this.draw();
    this.position.x += this.velocity.x;
    this.position.y += this.velocity.y;
  }
}

class EnemyProjectile {
  constructor({position, velocity}) {
    this.position = position;
    this.velocity = velocity;

    this.radius = 3;
  }

  draw() {
    c.beginPath();
    c.arc(this.position.x, this.position.y, this.radius, 
      0, Math.PI * 2);
    
    c.fillStyle = 'red';
    c.fill();
    c.closePath();
  }

  update() {
    this.draw();
    this.position.x += this.velocity.x;
    this.position.y += this.velocity.y;
  }
}

class Enemy {
  constructor({position}) {    
    this.velocity = {
      x: 0,
      y: 0
    }

    const image = new Image();
    image.src = './enemy.png';
    image.onload = () => {
      console.log('image load enemy');
      const scale = 1;
      this.image = image;
      this.width = image.width * scale;
      this.height = image.height * scale;
      this.position = {
        x: position.x,
        y: position.y
      }
    }
    
  }

  draw() {
    // c.fillStyle = 'red';
    // c.fillRect(this.position.x, this.position.y, this.width,
    //   this.height);
    
    c.drawImage(this.image, this.position.x, this.position.y,
      this.width, this.height);
    
  }

  update({velocity}) {
    if(this.image) {
      this.draw();
      this.position.x += velocity.x;
      this.position.y += velocity.y;
    }
  }

  shoot(enemyProjectiles){
    enemyProjectiles.push(new EnemyProjectile({
      position: {
        x: this.position.x + this.width/2,
        y: this.position.y + this.height
      },
      velocity: {
        x: 0,
        y: 5
      }
    }));
  }
}

class Grid {
  constructor() {
    console.log('grid');
    this.position = {
      x: 0,
      y: 0
    };

    this.velocity = {
      x: 3,
      y: 0
    };

    this.enemies = [];

    const columns = 5;
    const rows = 2;

    this.width = columns * 30;

    for(let i = 0; i < columns; i++) {
      for(let j = 0; j < rows; j++) {
        this.enemies.push(
          new Enemy({
            position: {
              x: i * 30,
              y: j * 30
            }
          })
        );
      }
    }
    console.log('grid: ' + this.enemies[0].position);
  }

  update() {
    this.position.x += this.velocity.x;
    this.position.y += this.velocity.y;

    this.velocity.y = 0;

    if( this.position.x + this.width >= canvas.width
      || this.position.x <= 0) {
      this.velocity.x = -this.velocity.x;
      this.velocity.y = 30;
    }
  }
}

const grids = [new Grid()];
const player = new Player();
const particles = [];
const projectiles = [];
const enemyProjectiles = [];

const keys = {
  a: {
    pressed: false
  },
  d: {
    pressed: false
  },
  space: {
    pressed: false
  }
}

let frames = 1
let game = {
  over : false,
  active: true
}

for(let i=0;i<100;i++){
	particles.push(new Particle({
		position: {
			x: Math.random() * canvas.width,
			y: Math.random() * canvas.height
		},
		velocity: {
			x: 0,
			y: 1
		},
		radius: Math.random() * 3,
		color: 'white'
	}))
}

function createParticles({object, color, fades}) {
	for(let i=0;i<15;i++){
		particles.push(new Particle({
			position: {
				x: object.position.x + object.width/2,
				y: object.position.y + object.height/2
			},
			velocity: {
				x: (Math.random() - 0.5) * 2,
				y: (Math.random() - 0.5) * 2
			},
			radius: Math.random() * 3,
			color: color || '#BAA0DE',
			fades: fades
		}))
	}
}

function animate() {
  if(!game.active) return
  
  requestAnimationFrame(animate);
  c.fillStyle = 'black';
  c.fillRect(0, 0, canvas.width, canvas.height);
  player.update();
  
  particles.forEach((particle, index) => {
	if(particle.position.y - particle.radius >= canvas.height) {
		particle.position.x = Math.random() * canvas.width,
		particle.position.y = -particle.radius
	}
	
	if(particle.opacity <= 0) {
		setTimeout(() => {
			particles.splice(index, 1)
		}, 0)
	} else {
		particle.update()
	}
	
  })
  
  enemyProjectiles.forEach((enemyProjectile, index) => {
    if(enemyProjectile.position.y + enemyProjectile.radius
      >= canvas.height) {
        setTimeout( () => {
          enemyProjectiles.splice(index, 1);
        }, 0);
    } else {
      enemyProjectile.update();
    }

    if(enemyProjectile.position.y + enemyProjectile.radius >=
      player.position.y && enemyProjectile.position.x +
      enemyProjectile.radius >= player.position.x &&
       enemyProjectile.position.x
      <= player.position.x + player.width) {
        console.log("FIM - PERDEU");

		createParticles({
			object: player,
			color: '#FA7A53'
		})
		
        setTimeout(() => {
          enemyProjectiles.splice(index, 1)
          player.opacity = 0
          game.over = true
        }, 0);

        setTimeout(() => {
          game.active = false
          let gameover = document.getElementById("over").click();
          gameover.value = true;
        }, 2000);
         
    }
  });

  projectiles.forEach((projectile, index) => {
    if(projectile.position.y + projectile.radius <= 0) {
      setTimeout( () => {
        projectiles.splice(index, 1);
      }, 0);
    } else {
      projectile.update();
    }
  });

  grids.forEach( (grid, gridIndex) => {
    grid.update();

    grid.enemies.forEach( (enemy, i) => {
      enemy.update({velocity: grid.velocity});

      projectiles.forEach((projectile, j) => {
        if(projectile.position.y - projectile.radius <= 
          enemy.position.y + enemy.height &&
          projectile.position.x + projectile.radius >=
          enemy.position.x && 
          projectile.position.x - projectile.radius <=
          enemy.position.x + enemy.width && projectile.position.y +
          projectile.radius >= enemy.position.y) {
			
            setTimeout(() => {
              const enemyFound = grid.enemies.find( 
                enemy2 => enemy2 === enemy);
              const projectileFound = projectiles.find( 
                projectile2 => projectile2 === projectile);

              if(enemyFound && projectileFound) {
				createParticles({
					object: enemy,
					fades: true
				})
                
                grid.enemies.splice(i, 1);
                projectiles.splice(j, 1);

                if(grid.enemies.length > 0) {
                  const firstEnemy = grid.enemies[0]
                  const lastEnemy = grid.enemies[grid.enemies.length-1]
                  grid.width = lastEnemy.position.x - firstEnemy.position.x
                  - lastEnemy.width
                  grid.position.x = firstEnemy.position.x;
                } else {
                  grids.splice(gridIndex, 1)
                  let gameover = document.getElementById("win").click();
                  gameover.value = true;
                }
              }
            }, 0);
          }
      })
    });
    if(frames % 80 === 0 && grid.enemies.length > 0) {
      console.log("qutad: " + Math.floor(Math.random() * grid.enemies.length));
      console.log("inimigo: " + grid.enemies[Math.floor(Math.random() * grid.enemies.length)].height);
      grid.enemies[Math.floor(Math.random() * grid.enemies.length)]
      .shoot(enemyProjectiles)
    }
  });

  if(keys.a.pressed && player.position.x >= 0) {
    player.velocity.x = -5;
    player.rotation = -0.15;
  } else if(keys.d.pressed && player.position.x + player.width
    <= canvas.width) {
    player.velocity.x = 5;
    player.rotation = 0.15;
  } else {
    player.velocity.x = 0;
    player.rotation = 0;
  }

  frames++
}

animate();

addEventListener('keydown', ({key}) => {
  if(game.over) return

  switch (key) {
    case 'a':
      console.log('left');     
      keys.a.pressed = true;
      break;
    case 'd':
      console.log('right');
      keys.d.pressed = true;
      break;   
    case ' ':
      console.log('space');
      keys.space.pressed = true;
      projectiles.push(new Projectile({
        position: {
          x: player.position.x + player.width/2,
          y: player.position.y
        },
        velocity: {
          x: 0,
          y: -5
        }
      }));

      break;
  }
})

addEventListener('keyup', ({key}) => {
  switch (key) {
    case 'a':
      console.log('left');     
      keys.a.pressed = false;
      break;  
    case 'd':
      console.log('right');
      keys.d.pressed = false;
      break;   
    case ' ':
      console.log('space');
      keys.space.pressed = false;
      break;
  }
})