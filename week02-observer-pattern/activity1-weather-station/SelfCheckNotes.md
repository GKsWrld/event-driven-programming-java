# Activity 1: Weather Station Self-Check Notes

1. **What is the role of the `Subject` interface?**
   It defines the contract (`registerObserver`, `removeObserver`, `notifyObservers`) that any publisher must implement so observers can subscribe, unsubscribe, and be notified uniformly without knowing concrete implementation details.

2. **What happens if you call `notifyObservers()` without registering any observers?**
   The `for (Observer o : observers)` loop iterates zero times and nothing happens—no errors or exceptions are thrown.

3. **What is the difference between `registerObserver()` and `removeObserver()`?**
   `registerObserver(o)` adds an observer to the `observers` list so it receives future updates; `removeObserver(o)` removes it from the list so it stops receiving updates (also preventing memory leaks when an observer is no longer needed).

4. **Why is the `observers` list stored as an instance variable?**
   Each `WeatherData` instance needs to maintain its own independent list of subscribed observers across multiple `setMeasurements()` calls throughout the object's lifetime.
