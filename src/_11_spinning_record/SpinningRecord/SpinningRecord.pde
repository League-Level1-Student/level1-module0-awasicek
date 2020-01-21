import ddf.minim.*;

Minim minim;
AudioPlayer song;

PImage pictureOfRecord; 
int xPosition = 0;
int yPosition = 0;
int angle = 0;

void setup() {
  size(600,600);
  pictureOfRecord= loadImage("record.png");
  pictureOfRecord.resize(height,width);
  minim = new Minim(this);
  song = minim.loadFile("awesomeTrack.mp3", 512);
}

void draw() {
  if(mousePressed) {
    song.play();
    angle++;
  } else {
    song.pause();
  }

  /* 
   * If we have this rotateImage in the if mousePressed statement then when the mouse
   * is not pressed the image of the record will be displayed without being rotated
   * the amount of the last angle. In other words, it will appear to keep resetting back
   * to the starting angle.
   */
  rotateImage(pictureOfRecord, angle); 

  image(pictureOfRecord, xPosition, yPosition);
}

void rotateImage(PImage image, int amountToRotate) {
  translate(width/2, height/2);
  rotate(amountToRotate*TWO_PI/360);
  translate(-image.width/2, -image.height/2);
}
