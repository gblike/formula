package examples

import com.raquo.laminar.api.L
import com.raquo.laminar.api.L._
import formula.{FormValue, Validation}

object Utils {
  def debugForm[A](name: String, form: FormValue[A]): Div =
    div(
      div(
        cls("card"),
        div(
          cls("card-header"),
          name
        ),
        div(
          cls("card-body"),
          L.form(
            form.node
          )
        ),
        div(
          cls("card-footer"),
          pre(
            child <-- form.signal.map {
              case Validation.Warnings(warnings, value) =>
                pre(
                  value.toString,
                  pre(
                    color("red"),
                    warnings.mkString("\n")
                  )
                )
              case Validation.Succeed(value)            =>
                value.toString
            }
          )
        )
      )
    )
}
