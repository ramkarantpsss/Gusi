#!/bin/bash
set -ex
npm install -g appium@next
appium driver install uiautomator2
appium driver install --source=npm appium-flutter-driver


appium -v
appium --log appium.log &>/dev/null &
