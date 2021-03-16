package task11stack;

class Stack {
	private int top;
	public String value[] = new String[100];

	Stack() {
		top = -1;
	}

	public void pushElement(String item) {
		if (top > value.length) {
			System.out.println("Stack over flow");
		} else {
			top++;
			value[top] = item;
		}
	}

	public String lastElement() {
		return value[top];
	}

	public String popElement() {
		return value[top--];
	}

	public boolean isEmpty() {
		if (top == -1)
			return true;
		else
			return false;
	}

	public void display() {
		for (int i = 0; i <= top; i++)
			System.out.print(value[i] + " ");
		System.out.println();
	}

}

public class InfixUsingStack {
	private static String op[] = { "(", ")", "*", "/", "+", "-", "<", ">",
			"<=", ">=", "==", "!=", "&&", "||" };

	/**
	 * check precedence of operators return true if first have high priority
	 * else false
	 * 
	 * @param first
	 *            contain operator of type string
	 * @param second
	 *            contain operator of type string
	 * @return true if first have high priority else false
	 */
	public static boolean checkPrecedence(String first, String second) {
		if ("/".equals(first) && "*".equals(second))
			return true;
		if ("-".equals(first) && "+".equals(second))
			return true;
		if ("(".equals(first))
			return false;
		for (int i = 0; i < op.length; i++) {
			if (op[i].equals(first))
				return true;
			if (op[i].equals(second))
				return false;
		}
		return false;
	}

	/**
	 * perform task on first and second operands with operator
	 * 
	 * @param first
	 *            contain number in String format
	 * @param second
	 *            contain number in String format
	 * @param op
	 *            contain operator
	 * @return answer
	 */
	public static int doTask(int first, int second, String op) {
		if ("+".equals(op)) {
			return first + second;
		} else if ("-".equals(op)) {
			return first - second;
		} else if ("*".equals(op)) {
			return first * second;
		} else if ("/".equals(op)) {
			return first / second;
		} else if ("<".equals(op)) {
			if (first < second)
				return 1;
			else
				return 0;
		} else if (">".equals(op)) {
			if (first < second)
				return 1;
			else
				return 0;
		} else if ("<=".equals(op)) {
			if (first <= second)
				return 1;
			else
				return 0;
		} else if (">=".equals(op)) {
			if (first >= second)
				return 1;
			else
				return 0;
		} else if ("==".equals(op)) {
			if (first == second)
				return 1;
			else
				return 0;
		} else if ("!=".equals(op)) {
			if (first != second)
				return 1;
			else
				return 0;
		} else if ("&&".equals(op)) {
			if (first == 1 && second == 1)
				return 1;
			return 0;
		} else if ("||".equals(op)) {
			if (first == 0 && second == 0)
				return 0;
			return 1;
		}
		return 0;
	}

	/**
	 * check whether it is operator or not
	 * 
	 * @param op
	 *            contain String
	 * @return true if op is operator else false
	 */
	public static boolean isOperator(String op) {
		for (int i = 0; i < InfixUsingStack.op.length; i++) {
			if (InfixUsingStack.op[i].equals(op))
				return true;
		}
		return false;
	}

	/**
	 * find result of infix operation
	 * 
	 * @param variable
	 *            contain infix expression in String format
	 * @return result of infix operation
	 */
	public static int infixValue(String variable) {
		String infix[] = variable.split(" ");
		Stack operators = new Stack();
		Stack operands = new Stack();
		for (int i = 0; i < infix.length; i++) {
			if (isOperator(infix[i]) == false) {
				/**
				 * push the element in operands stack when String is not
				 * operator
				 */
				operands.pushElement(infix[i]);
			} else if (")".equals(infix[i])) {
				/**
				 * perform all task until it get )
				 */
				String opera = operators.popElement();
				while ("(".equals(opera) == false) {
					int second = Integer.parseInt(operands.popElement());
					int first = Integer.parseInt(operands.popElement());
					int result = doTask(first, second, opera);
					operands.pushElement(String.valueOf(result));
					opera = operators.popElement();
				}
			} else {
				if (operators.isEmpty()) {
					/**
					 * if operator stack is empty the push the operator
					 */
					operators.pushElement(infix[i]);
				} else {
					String last = operators.lastElement();
					if (checkPrecedence(last, infix[i])) {
						/**
						 * if last operator have high precedence then it perform
						 * task
						 */
						int second = Integer.parseInt(operands.popElement());
						int first = Integer.parseInt(operands.popElement());
						String opera = operators.popElement();
						int result = doTask(first, second, opera);
						operands.pushElement(String.valueOf(result));
						operators.pushElement(infix[i]);
					} else {
						/**
						 * if last have low precedence then push into operator
						 * stack
						 */
						operators.pushElement(infix[i]);
					}
				}
			}
		}
		/***
		 * after performing task if any operator left the perform task until
		 * operator is not empty
		 */
		while (operators.isEmpty() != true) {
			int second = Integer.parseInt(operands.popElement());
			int first = Integer.parseInt(operands.popElement());
			String opera = operators.popElement();
			int result = doTask(first, second, opera);
			operands.pushElement(String.valueOf(result));
		}
		return Integer.parseInt(operands.popElement());
	}
}
