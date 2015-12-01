# Reactive Programming for Android
Exercise for K-dag, December 2015

## Some handy links

* [ReactiveX](http://reactivex.io/) - The home for the whole Rx family. Once you learn how to read
  the documentation, it's pretty handy.
* [RxJava](https://github.com/ReactiveX/RxJava) - Especially the wiki with the JavaDoc can come in
  handy.
* [RxAndroid](https://github.com/ReactiveX/RxAndroid/wiki) - Only contains
  `AndroidSchedulers.mainThread()`. But the wiki contains links to all the other
  Rx-related Android projects.
* [RetroLambda](https://github.com/evant/gradle-retrolambda) - You really want to use lambdas
  when writing a lot of Rx code.
  
## Exercises

There are three exercises described here. One that is pure RxJava and two that focuses on
Android. The exercises are completely independent of each other and you can do one or more in
any order you like. Look through them and start with whichever piques your interest.

The first exercise is probably the easier one for Android.

### Exercise 1: Reactive Sign up Form

In this case, you present the user with a form to sign up for a lifelong subscription to 
Spam Unlimited™. The user needs to fill in an email address, a user name and a password.

Your job is to make the sign up button enabled when all three fields contain valid values.

* The email address must contain an '@' sign and at least one period.
* The username must not contain any whitespace and must be at least five characters long.
* The password must be at least 5 characters long. (Feel free to add more restrictions.)

The exercise is done in `SignUpActivity`. If you don't know where to start, here's a step-by-step
for you:

1. 
    Make all three text fields observable. `RxTextView` can help you.
2. 
    Subscribe to them, one by one, and log the result, just to see that it works.
3. 
    For each of the text fields, map the emitted value to `true` or `false` depending on
    whether it is valid or not.
4. 
    Use `Observable.combineLatest` to join all three streams into one and enable the button if all
    three values are true. (Try using `Observable.zip` instead. Why doesn't it work?)
5. 
    For bonus points: Use all three text field streams *and* a stream of button clicks to capture 
    the values that should be used for signing up.


### Exercise 2: Android Search while Typing; the Rx Way.

This is a use case that fits the Rx paradigm very well. You are presented with an `EditText` field
and a `ListView`. The list is populated with search results as you are typing.

In this particular case we're querying a REST api for music albums. It's not the quickest api ever,
so there are some requirements:

* The search query needs to be at least 3 characters long.
* You can't search more often than once per second. I originally did this with GitHub, but there
  the limit is 10 times per minute per IP-address, so this is a quite reasonable limit.
  
When you've imported the project, this exercise is found in the `AlbumSearchActivity`.

I would recommend to do things in the following order:

1. 
    Make the `queryEditText` into an `Observable`. `RxTextView` can help you with this.
2. 
    Subscribe and log (or alert) whatever is typed in the query field. Verify that you get the
    events.
3. 
    Filter the events so you only get queries longer than three characters. Verify in the log 
    again.
4. 
    Limit the stream of events to maximum one per second. You can look at function such as
    `throttle...`, `debounce` and `sample`. Can you figure out what the difference is between
    these methods?
5. 
    Now, when you know that you are following the restrictions, it's time to do some searching.
    Use the provided api to search for albums matching the query. Use `observeOn` or `subscribeOn`
    to handle threading. What's the difference between these two methods?
6. 
    What you get back is a `SearchResult` object containing a list of `Album` objects. Can you
    use Rx to transform these into strings?
7. 
    When you're done, all you need to do is to update the `ListAdapter` with the new data and it
    will be shown. Remember to do this on the main thread.

### Exercise 3: Try out some of the more common RxJava methods

This is not Android based at all but you can still import the project in Android Studio if
you don't prefer another IDE for plain java projects.

The exercises are found in https://github.com/kevinvandervlist/rx-playground. Look for the
non-interactive exercises. There a both tests and some skeleton code to start fill out to fix
the test cases.

Good luck!
 
 