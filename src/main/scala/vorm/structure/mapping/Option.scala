package vorm.structure.mapping

import vorm._
import structure._
import reflection._

class Option
  ( val settings : Map[Reflection, EntitySettings],
    val reflection : Reflection,
    val parent : Mapping )
  extends Mapping
  with HasParent
  with HasChildren
  with HasReflection
  {
    lazy val children
      = new OptionItem( settings, reflection.generics(0), this ) :: 
        Nil
  }
