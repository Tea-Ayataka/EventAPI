# EventAPI
A event api written in Kotlin

# Usage example

Declaration of normal event class
```
class MouseClickEvent : Event()
```

Declaration of cancelable event class
```
class KeybordEvent : Event() : Cancelable
```

Implementation of event listener
```
object ExampleListener {
  init {
    // register listener
    EventManager.register(this)
  }
  
  @EventListener
  fun onMouseClick(event: MouseClickEvent) {
    printf("Clicked mouse!")
  }
  
  @EventListener(EventPriority.HIGH)
  fun onMouseClickFirst(event: MouseClickEvent) {
    printf("High priority!")
  }
}
```

Implementation of event executor
```
fun executeEvent() {
  // Execute normal event
  EventManager.fire(MouseClickEvent())
  
  // Execute cancelable event
  val keyboardEvent = KeyboardEvent()
  EventManager.fire(keyboardEvent)
  
  if(keyboardEvent.canceled) {
    // if canceled
  }
}
```
