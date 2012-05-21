package vorm.extensions

import collection.immutable.Queue

object OrderedMap {
  def apply[A, B](elems: (A, B)*) =
    new OrderedMap(Map(elems: _*), Queue(elems: _*))
}
/**
 * An ordered map implementation that should perform effectively on all operations except
 * removal, where it performs linearly.
 */
class OrderedMap[A, B](
  map: Map[A, B] = Map[A, B](),
  queue: Queue[(A, B)] = Queue()
) extends Map[A, B] {
  def get(key: A) =
    map.get(key)
  def iterator =
    queue.iterator
  def +[B1 >: B](kv: (A, B1)) =
    new OrderedMap(
      map + kv,
      queue enqueue kv
    )
  def -(key: A) =
    new OrderedMap(
      map - key,
      queue filter (_._1 != key)
    )
}