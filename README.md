# Indoor Wi-Fi positioning
We suggest Wi-Fi positioning based on **Fingerprinting**
* Figerprinting - A unique characteristic of the radio signal (e.g. Identify a position based on a set of RSSIs associated with APs

### Goal
Develop Android application for indoor positioning (AI 공학관 4, 5층) using Wi-Fi and sensors

### Blueprint of AI 공학관
<img width="711" alt="스크린샷 2022-05-09 오후 9 53 12" src="https://user-images.githubusercontent.com/50310635/167414331-df3c09ef-82ee-41f5-ab18-9369ea44a8aa.png">





## 1st week

### Progress
* Set the role for each member
* Create Admin App 
* Implement Wi-Fi sensing
* Create User App

### To Do
* Collect data using another sensors (e.g. GPS, Barometer)
* Implement back-end server using firebase realtime database
* Implement python environment for analysis sensor data

## 2nd week

### Progress

* Make an app that can measure the RSSI value of Wi-Fi  
* upload the measured value to the database (FIREBASS).

Contains the RSSI (Received Signal Strength Indication Value) of the WAP (Wireless Access Point) at the measured location. When RSSI values are expressed in negative format, the closer the value is to 0, the stronger the received signal.

![WF1](https://user-images.githubusercontent.com/104605749/168459127-5470ae9b-f954-41da-bf5a-721f58a41072.jpg)

SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS

<img src="https://user-images.githubusercontent.com/104605749/168459534-4885bdc5-7205-4140-9ace-c9283cf9a16d.jpg" width = "200" height = "400"/>

## Deployment

* [Android](http://www.dropwizard.io/1.0.2/docs/) - Mobile development platform
* [Firebase](https://maven.apache.org/) - Back-end design
* [Python](https://rometools.github.io/rome/) - Sensor data analysis

## Built With
* **minSdk:21**
* **targetSdk:31**


## Authors

* **1st week** - *MinHyung Lee* - [MinHyung](https://github.com/agtmwebtoon)
* **2st week** - *Doe* - 
* **3st week** - *Doe* - 
* **4st week** - *Doe* - 
* **5st week** - *MinHyung Lee* - [MinHyung](https://github.com/agtmwebtoon)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Knowledge about 802.11 protocol
* Basic android programming skill with java
* Basic Python programming skill
* Data analysis technique
