package net.ayataka.eventapi

@Target(AnnotationTarget.FUNCTION)
@SuppressWarnings("unused")
annotation class EventListener(val priority: EventPriority = EventPriority.NORMAL)
