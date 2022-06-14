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

<img src="https://user-images.githubusercontent.com/104605749/173557409-3d7c79a0-73ac-4fc6-bbbd-23bcb9dfa884.jpg" width = "200" height = "400"/>

### Wi-Fi Signal Stength

Contains the RSSI of the WAP at the measured location. When RSSI values are expressed in negative format, the closer the value is to 0, the stronger the received signal.

![WF1](https://user-images.githubusercontent.com/104605749/168459127-5470ae9b-f954-41da-bf5a-721f58a41072.jpg)

### Data exploration

![image](https://user-images.githubusercontent.com/104605749/168989902-f012af90-0697-417f-bbb3-9eb778ab7ed0.png)

Only the reception strength of the measured value is measured in the (FIREBASE) data set. Convert the measured value to a data frame using Python

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

### Progress

* System Architecture
* Model evaluation

#### System Architecture
* Location data collection
![image](https://user-images.githubusercontent.com/74479972/173633557-7094d8d3-3b95-45ed-a293-f74488942997.png)
If possible to measure the interior of the classroom, measure approximately 30 randomly.<br>
If impossible to measure the interior of the classroom, measure approximately 30 times at random by dividing the area between the rooms accurately.

#### Model evaluation
* Decision Tree without preporcessing.
* ![image](https://user-images.githubusercontent.com/74479972/173635178-41b83112-a71f-4168-8c68-1ee8dcff2a61.png)
  Accuracy: 64%   => Data need to be preprocessed!

* <b>Data preprocessing - Augmentation</b> <br>: Techniques used to increase the amount of data by adding slightly modified copies of already existing data.
* ![image](https://user-images.githubusercontent.com/74479972/173635784-28d8a3f0-ce1e-4dde-84c1-2af6533fe35b.png)
   We covered each area with N(0, 3) for classroom, N(0, 2.3) for corridors according to the normal distribution and summed up with original dataset.
   
* <b>Data preprocessing - Data filtering</b> <br>: remove some unwanted components or features from a signal.
<br> Some observation is sparse.(For example, individually operated hotspot..)
<br> We regarded it as useless.
<br> We drop observations consisted of 45 percent missing value.
![image](https://user-images.githubusercontent.com/74479972/173636788-ce56ec70-6da1-41e0-ab55-cc5d06794f79.png)

* <b>Data preprocessing - Hyperarameter tuning</b> <br>RandomForest with GridSearch: remove some unwanted components or features from a signal.
 ![image](https://user-images.githubusercontent.com/74479972/173637264-1e20131f-2afd-4e0d-9066-7e17fcd66b86.png)

#### After data preprocessing
![image](https://user-images.githubusercontent.com/74479972/173637834-78244ad6-deae-414b-82a9-0e32b4e123d5.png)

## 4th week
### Progress

* Dataset collection
* Dataset Reorganization
* Implement restAPI using google AI platform
* Associate information with user apps

### Release to User App
- Using Google AI Platform:  
  AI Platform is a service created by Google Cloud Platform that helps you implement and deploy machine learning models for production    
  ![image](https://user-images.githubusercontent.com/31121701/170215623-20bf009f-5749-4e11-92cd-eaba135f097c.png)  
- Tools to help implement, deploy
  - Serving, TFX, Explainable AI, TPU
  - AI Hub, Kubeflow
  - Various tools are available and are increasingly being added

### RestAPI
   ![image](https://user-images.githubusercontent.com/31121701/170223860-f086afa8-88f1-44c9-b15f-d159014217fe.png)    

   After deep learning the dataset through the Google AI Platform and completing modeling, it is released using RestAPI  
   It uses Google's Identity Platform Rest API to perform common user tasks, such as user token tasks.  

### Check Location
  ![image](https://user-images.githubusercontent.com/31121701/170227996-b554011a-d28b-4f75-8542-cc5a88d5c8ee.png) ![image](https://user-images.githubusercontent.com/31121701/170228397-959ba7e6-5320-44e1-aae2-b77f893a023f.png)









## Deployment

* [Android](http://www.dropwizard.io/1.0.2/docs/) - Mobile development platform
* [Firebase](https://maven.apache.org/) - Back-end design
* [Python](https://rometools.github.io/rome/) - Sensor data analysis

## Built With
* **minSdk:21**
* **targetSdk:31**


## Authors

* **1st week** - *MinHyung Lee* - [MinHyung](https://github.com/agtmwebtoon)
* **2nd week** - *Kyungho Choi* - [Kyungho](https://github.com/KyunghoC)
* **3rd week** - *Hyegyun Yim* - [hgyim00](https://github.com/hgyim00)
* **4th week** - *Yunho Kim* - [YunHo](https://github.com/ua1it)
* **5th week** - *MinHyung Lee* - [MinHyung](https://github.com/agtmwebtoon)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Knowledge about 802.11 protocol
* Basic android programming skill with java
* Basic Python programming skill
* Data analysis technique
