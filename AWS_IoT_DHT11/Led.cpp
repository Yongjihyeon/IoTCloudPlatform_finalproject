#include "Led.h"

Led::Led(int pin) {
  // Use 'this->' to make the difference between the
  // 'pin' attribute of the class and the 
  // local variable 'pin' created from the parameter.
  this->pin = pin;
  init();
}
void Led::init() {
  pinMode(pin, OUTPUT);
  // Always try to avoid duplicate code.
  // Instead of writing digitalWrite(pin, LOW) here,
  // call the function off() which already does that
  off();
  state = LED_OFF;
}
void Led::on() {
  digitalWrite(pin, HIGH);
  // tone(pin, 262, 500);
  state = LED_ON;
}
void Led::off() {
  digitalWrite(pin, LOW);
  // noTone(pin);
  state = LED_OFF;
}

byte Led::getState() {
  return state;
}
