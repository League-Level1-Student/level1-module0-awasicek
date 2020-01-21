
void setup() {
  size(600, 600);
  background(#000000);
}


void draw() {
  
 
  makeMagical();
  for(int i = 0; i < 300; ++i) {
    fill(i, 2*i, 3*i);
    ellipse(getWormX(3*i), getWormY(3*i), 20, 20);
  }

}

float frequency = .005;
float noiseInterval = PI;

void makeMagical() {
    fill( 0, 0, 0, 10 );
    rect(0, 0, width, height);
    noStroke();
}

float getWormX(int i) {
    return map(noise(i*noiseInterval + frameCount * frequency), 0, 1, 0, width);
}

float getWormY(int i) {
    return map(noise(i*noiseInterval+1 + frameCount * frequency), 0, 1, 0, height);
}
