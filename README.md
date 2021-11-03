# Tinder-Like-News-Swipe-Application
 Android-Mobile-Application

## 1.Intro: This is a Android project inspired by Tinder using Java.

IDE: Android Studio

Application Architecture: MVVM 

<img width="465" alt=" project structure" src="https://user-images.githubusercontent.com/27842254/140228956-c27913d6-36d1-4c91-b11b-6a91004689de.png">


## 2.The application comes with a single activity and 4 major fragments 

( Home Fragment , SearchFragment , SavedFragment and Item Details )

(1).Home fragment: shows all the latest news obtained from newsapi.org. 
The users can swipe right to save the news for a later read, swipe left to discard the news. 
It can also be achieved by using the thumb up and thumb down buttons instead of swiping gestures.


(2).Search fragment: type key words to search for news.


(3).Save fragment: displays all the news that the user has liked/swiped right/thumbed up.

Users are able to click on the heart icon to unlike/unsave the news, scroll up and down of the saved news


(4).Item details fragment: click on the news image tiles to read the details of the news

<img width="338" alt="Main Interface" src="https://user-images.githubusercontent.com/27842254/140229050-515f7830-205c-4622-ae99-d4769fecd2c3.png">




<img width="337" alt="saved item details" src="https://user-images.githubusercontent.com/27842254/140229099-a24e1d16-1fa6-49ad-b264-312ce04a75e3.png">


## Major Steps:
Designed the News app based on Google Component Architectural MVVM Pattern

Implemented the bottom bar & page navigation using JetPack navigation component

Utilized 3rd party CardStackView(RecyclerView) to support swipe gestures for liking/disliking the news

Built the Room Database with LiveData & ViewModel to support local cache and offline model

Integrated Retrofit and LiveData to pull the latest news data from a RESTFUL endpoint (newsapi.org)


#### References:
https://www.geeksforgeeks.org/tinder-swipe-view-with-example-in-android/

https://github.com/yuyakaido/CardStackView

https://github.com/Lucie-Wang
