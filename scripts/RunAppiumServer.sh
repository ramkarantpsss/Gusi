#!/bin/bash
set -ex
npm install -g appium@next
appium driver install uiautomator2
appium driver install --source=npm appium-flutter-driver
appium plugin install --source=npm appium-reporter-plugin

appium -v
appium --use-plugins=appium-reporter-plugin &
