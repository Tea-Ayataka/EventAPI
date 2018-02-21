# EventAPI
A event api written in Kotlin

# Usage example

Normal event
```
class MouseClickEvent : Event()
```

Cancelable event
```
class KeybordEvent : Event() : Cancelable
```


Event listener
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

Event executor
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
