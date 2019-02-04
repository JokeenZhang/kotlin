/*
 * Copyright 2010-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.ir.expressions

interface IrDynamicExpression : IrExpression

interface IrDynamicOperatorExpression : IrDynamicExpression {
    val operator: IrDynamicOperator

    val valueArgumentsCount: Int
    fun getValueArgument(index: Int): IrExpression?
    fun putValueArgument(index: Int, valueArgument: IrExpression?)
    fun removeValueArgument(index: Int)
}

interface IrDynamicMemberExpression : IrDynamicExpression {
    val memberName: String
    var receiver: IrExpression
}

enum class IrDynamicOperator(val image: String, val isAssignmentOperator: Boolean = false) {
    UNARY_PLUS("+"),
    UNARY_MINUS("-"),
    EXCL("!"),
    PREFIX_INCREMENT("++", isAssignmentOperator = true),
    POSTFIX_INCREMENT("++", isAssignmentOperator = true),
    PREFIX_DECREMENT("--", isAssignmentOperator = true),
    POSTFIX_DECREMENT("--", isAssignmentOperator = true),

    BINARY_PLUS("+"),
    BINARY_MINUS("-"),
    MUL("*"),
    DIV("/"),
    MOD("%"),
    GT(">"),
    LT("<"),
    GE(">="),
    LE("<="),
    EQEQ("=="),
    EXCLEQ("!="),
    EQEQEQ("==="),
    EXCLEQEQ("!=="),
    ANDAND("&&"),
    OROR("||"),

    EQ("=", isAssignmentOperator = true),
    PLUSEQ("+=", isAssignmentOperator = true),
    MINUSEQ("-=", isAssignmentOperator = true),
    MULEQ("*=", isAssignmentOperator = true),
    DIVEQ("/=", isAssignmentOperator = true),
    MODEQ("%=", isAssignmentOperator = true),

    ARRAY_ACCESS("[]"),
    INVOKE("()")
}