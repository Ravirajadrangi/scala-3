/*                     __                                               *\
**     ________ ___   / /  ___     Scala API                            **
**    / __/ __// _ | / /  / _ |    (c) 2002-2009, LAMP/EPFL             **
**  __\ \/ /__/ __ |/ /__/ __ |    http://scala-lang.org/               **
** /____/\___/_/ |_/____/_/ | |                                         **
**                          |/                                          **
\*                                                                      */

// $Id$


package scala.runtime


final class RichLong(x: Long) extends Proxy with Ordered[Long] {

  // Proxy.self
  def self: Any = x

  // Ordered[Long].compare
  def compare(y: Long): Int = if (x < y) -1 else if (x > y) 1 else 0

  /** See <code>Iterator.range</code>. */
  def until(end: Long) = Range.Long(x, end, 1L)

  /** See <code>Iterator.range</code>. */
  def until(end: Long, step: Long) = Range.Long(x, end, step)

  /** like <code>until</code>, but includes the last index */
  def to(end: Long) = Range.Long.inclusive(x, end, 1L)

  /** like <code>until</code>, but includes the last index */
  def to(end: Long, step: Long) = Range.Long.inclusive(x, end, step)

  def min(y: Long): Long = if (x < y) x else y
  def max(y: Long): Long = if (x > y) x else y
  def abs: Long = if (x < 0) -x else x

  def toBinaryString: String = java.lang.Long.toBinaryString(x)
  def toHexString: String = java.lang.Long.toHexString(x)
  def toOctalString: String = java.lang.Long.toOctalString(x)
}
