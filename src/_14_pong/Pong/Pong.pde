import ddf.minim.*;

final int BALL_RADIUS = 30;
final int PADDLE_WIDTH = 50;
final int PADDLE_LENGTH = 125;

Minim minim;
AudioSample sound;
PImage backgroundImage;
int ballX = 400;
int ballY = 300;
int ballSpeedX = 5;
int ballSpeedY = 2;

void setup() {
  size(800, 600);
  backgroundImage = loadImage("pong_background.png");
  minim = new Minim (this);
  sound = minim.loadSample("pong.wav", 128);
}

void draw() {
  image(backgroundImage, 0, 0, width, height);
  
  // ball
  fill(255, 0, 0);
  stroke(50, 0, 0);
  ellipse(ballX, ballY, BALL_RADIUS, BALL_RADIUS);
  
  ballX += ballSpeedX;
  ballY += ballSpeedY;
  
  // paddle
  fill(#FFFFFF);
  rect(width - PADDLE_WIDTH, mouseY, PADDLE_WIDTH, PADDLE_LENGTH);
  
  // check bounds & collisions
  if(ballX > width - PADDLE_WIDTH && ballY > mouseY && ballY < mouseY + PADDLE_LENGTH) {
    ballSpeedX = -ballSpeedX;
    sound.trigger();
  }
  
  if(ballX > width || ballX < 0) {
    ballSpeedX = -ballSpeedX;
    sound.trigger();
  }
  if(ballY > height || ballY < 0) {
    ballSpeedY = -ballSpeedY;
    sound.trigger();
  }
}
