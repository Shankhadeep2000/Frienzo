# Frienzo
THIS THE LINK FOR SCREEN RECORDING OF MY APP WHICH I SUBMITED IN HACKATHON:[https://youtu.be/YYgEOQ4O1a8]
This is an chatting I developed during an Hackathon 2k21 .It is a chatting app where people can chat , update there status, give feeling to the messages, etc.

It mainly contains sign up page which has two ways : Phone Number or By email You can signIn through email and Google ;

It has a home page with story/status bar and the user recycler view;

Function It perform:

A person can send pictures or documents with the help of attachment button in the chatting page.
It is important for a person to send a document like picture , pdf , outher documents to another person.

A person can Login into the app with various ways like google , phone Number , Email.
It is important to give a smooth experience for your User so it can be achieved by giving them suitable ways to login.

A person can chat in a group with all the members.
Friends always want to chat amoung themselves so they can chat in this Room.

It is fast and instant.
Since it is connected to a realtime database it will deliver a persons message in the real time .

A person can upload your status.
Whis will be vissible to all . Every person wants to express there feeling therefore they can show it through status.

A person can delete a message.
It is possible for a person thet he/she may send wrong message to a person or in the group , at that time he/she can delete it for everyone or for him/herself.

A person can add feelings to your message like some emoji's. It is an advanced world if a person wants to express his/her feelings regarding a message the use emoji ,
and send it again but in this app you can give the emoji to a particular message.

## Screenshots of the application:
![Screenshot_20210620-140842_Google Play services](https://user-images.githubusercontent.com/75299574/176610087-99efca00-9035-4f72-8660-324ad61854a3.jpg)

![Screenshot_20210620-140650_Frienzo](https://user-images.githubusercontent.com/75299574/176610184-a8d58f03-cce8-44ed-a35c-81cced8e73cd.jpg)

![Screenshot_20210620-135844_Frienzo](https://user-images.githubusercontent.com/75299574/176610226-64ac5c89-3ccc-4c31-b302-7ca2b908a080.jpg)
![Screenshot_20210620-135924_Frienzo](https://user-images.githubusercontent.com/75299574/176610244-9955fc31-64dd-40dd-9e6a-11da178c7f0a.jpg)
![Screenshot_20210620-135844_Frienzo](https://user-images.githubusercontent.com/75299574/176610330-56d86f4c-1ee2-46f5-b0a7-00aaac3139db.jpg)

Challenges I ran into:

I ran various Challenges:-
1. I got many errors when I import the external libraries into my project.
it is giving android.support.v4.app.INotificationSideChannel found in modules core-1.5.0-runtime (androidx.core:core:1.5.0) and
support-compat-26.1.0-runtime which I solved by adding this to every dependencies except default dependencies{
        exclude group: "com.android.support", module: "support-compat"
        exclude group: "com.android.support", module: "support-media-compat"
    }
    
2. when I used URI library I got this one URI is not registered (Settings | Languages & Frameworks | Schemas and DTDs) in applicationContext.
xml which is very iritating while write code since it gives the red color that scares me ,
I solved this bySince this is in IntelliJ IDEA . 
If you place the cursor over the URL (or select it), a red bulb on the left border of the window.
That red bulb, when clicked,it will give me some options to correct any errors. One of the options is to download the DTD (Fetch external resource) and clicked it.

3. when I am add an toolbar with the help of setSupportActionBar(binding.toolbar) ,
I ran into this error that kinda freaks me out which I am not getting how to solve Do not request
Window.FEATURE_SUPPORT_ACTION_BAR and set WindowActionBar to false in your theme to use a toolbar instead the searched in google
; after a lot of searches I finaly got the solution to stack overflow ie <item name="windowActionBar">true</item>
        <item name="windowNoTitle">true</item> I added this to my theme.
        
4. Android gives error “Cannot fit requested classes in a single dex file” this error got me a headache finnaly after a lot of searched i got the solutioimplementation
'androidx.multidex:multidex:2.0.1' add it to my dependencies , and adding it to my build.gradle multiDexEnabled true

5. String too large to encode using UTF-8 written instead as 'STRING_TOO_LARGE' I solved by deleting some drawables.

6. I ran into other silly errors.

Technologies and external libraries  I used:
Firebase Authentication, 
Firebase Analytics
Firebase Storage
Firebase Real time database
external libraries:

 implementation platform('com.google.firebase:firebase-bom:28.1.0')

    implementation ('com.google.firebase:firebase-analytics')
            {
                exclude group: "com.android.support", module: "support-compat"
                exclude group: "com.android.support", module: "support-media-compat"
            }
    implementation ('com.google.firebase:firebase-auth')
            {
                exclude group: "com.android.support", module: "support-compat"
                exclude group: "com.android.support", module: "support-media-compat"
            }
    implementation ('com.google.firebase:firebase-storage')
            {
                exclude group: "com.android.support", module: "support-compat"
                exclude group: "com.android.support", module: "support-media-compat"
            }
    implementation ('com.google.firebase:firebase-database')
            {
                exclude group: "com.android.support", module: "support-compat"
                exclude group: "com.android.support", module: "support-media-compat"
            }
    implementation ('com.github.mukeshsolanki:android-otpview-pinview:2.1.2')
            {
                exclude group: "com.android.support", module: "support-compat"
                exclude group: "com.android.support", module: "support-media-compat"
            }
    implementation ('androidx.multidex:multidex:2.0.1')
            {
                exclude group: "com.android.support", module: "support-compat"
                exclude group: "com.android.support", module: "support-media-compat"
            }
    implementation ('com.google.android.gms:play-services-auth:19.0.0')
            {
                exclude group: "com.android.support", module: "support-compat"
                exclude group: "com.android.support", module: "support-media-compat"
            }
    implementation ('com.github.bumptech.glide:glide:4.12.0')
            {
                exclude group: "com.android.support", module: "support-compat"
                exclude group: "com.android.support", module: "support-media-compat"
            }
    implementation ('com.github.pgreze:android-reactions:1.5.1')
            {
                exclude group: "com.android.support", module: "support-compat"
                exclude group: "com.android.support", module: "support-media-compat"
            }
    implementation ('com.github.3llomi:CircularStatusView:V1.0.2')
            {
                exclude group: "com.android.support", module: "support-compat"
                exclude group: "com.android.support", module: "support-media-compat"
            }
    implementation ('com.github.OMARIHAMZA:StoryView:1.0.2-alpha')
        {
            exclude group: "com.android.support", module: "support-compat"
            exclude group: "com.android.support", module: "support-media-compat"
        }
    implementation ('com.github.sharish:ShimmerRecyclerView:v1.3')
            {
                exclude group: "com.android.support", module: "support-compat"
                exclude group: "com.android.support", module: "support-media-compat"
            }
    implementation ('de.hdodenhof:circleimageview:3.1.0')
            {
                exclude group: "com.android.support", module: "support-compat"
                exclude group: "com.android.support", module: "support-media-compat"
            }
 
 
 Each have their own uses.
