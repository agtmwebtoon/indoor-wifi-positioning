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

* Make an Admin app that can measure the RSSI value of Wi-Fi
* After uploading the measurement value to the database (FIREBASE), convert it using Python

### Admin measurement app testing

Use the spinner to select the number of floors and  and press the START button to find the RSSI(Received Signal Strength Indication Value) value of nearby Wi-Fi and inform the WAP(Wireless Access Point) and distance.

<img src="https://user-images.githubusercontent.com/104605749/168459534-4885bdc5-7205-4140-9ace-c9283cf9a16d.jpg" width = "200" height = "400"/>

### Wi-Fi Signal Stength

Contains the RSSI of the WAP at the measured location. When RSSI values are expressed in negative format, the closer the value is to 0, the stronger the received signal.

![WF1](https://user-images.githubusercontent.com/104605749/168459127-5470ae9b-f954-41da-bf5a-721f58a41072.jpg)

### Data exploration

```
import firebase_admin
from firebase_admin import db
from firebase_admin import credentials
import pandas as pd
import numpy as np
```

```
cred = credentials.Certificate("myKey.json")

firebase_admin.initialize_app(cred,
{'databaseURL': 'https://wifi-indoor-positioning-default-rtdb.
                                             firebaseio.com/'})
```

```
#원하는 호 수 => 504호 => (5층/4호)
ref = db.reference('?층/??호')
p = ref.get()
get_list = []
```

```
df = pd.DataFrame(p)
df.index = np.arange(len(df))

#호 수로 입력
df["target"] = ???

df
```

![image](https://user-images.githubusercontent.com/104605749/168987604-b56232fc-b8cf-43f3-aea7-baa4487dab73.png)

## 3rd week

## Deployment

* [Android](http://www.dropwizard.io/1.0.2/docs/) - Mobile development platform
* [Firebase](https://maven.apache.org/) - Back-end design
* [Python](https://rometools.github.io/rome/) - Sensor data analysis

## Built With
* **minSdk:21**
* **targetSdk:31**


## Authors

* **1st week** - *MinHyung Lee* - [MinHyung](https://github.com/agtmwebtoon)
* **2st week** - *Kyungho Choi* - [Kyungho](https://github.com/KyunghoC)
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
