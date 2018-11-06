 calculator = document.querySelector('.calculator');
const keys = calculator.querySelector('.calculator_key');
const screen = calculator.querySelector('.calculator_screen');

keys.addEventListener('click', event => {
    if (event.target.matches('button')) {
        const key = event.target;
        const action = key.dataset.action;
        const keyContent = key.textContent;
        const screenContent = screen.textContent;
        const previousKeyType = calculator.dataset.previousKeyType;

        if (action !== 'clear') {
            const clearButton = calculator.querySelector('[data-action=clear]');
            clearButton.textContent = 'C';
        }

        // Remove .is-depressed class from all keys
        Array.from(key.parentNode.children)
          .forEach(k => k.classList.remove('is-depressed'));

        if (action === 'add' ||
            action === 'subtract' ||
            action === 'multiply' ||
            action === 'divide')
        {
            const firstValue = calculator.dataset.firstValue;
            const operator = calculator.dataset.operator;
            const secondValue = screenContent;

            if (firstValue && operator && previousKeyType !== 'operator' &&
                previousKeyType !== 'calculate') {
                screen.textContent = calculate(firstValue, operator, secondValue);
            }

            calculator.dataset.firstValue = screen.textContent;
            calculator.dataset.operator = action;
            key.classList.add('is-depressed');
            // Add custom attribute
            calculator.dataset.previousKeyType = 'operator';
        }
        else if (action === "decimal")
        {
            if (!screenContent.includes('.')) {
                screen.textContent = screen.textContent + keyContent;
                if (previousKeyType === 'operator' || previousKeyType === 'operator') {
                    screen.textContent = '0.';
                }
            }
            // Add custom attribute
            calculator.dataset.previousKeyType = 'decimal';
        }
        else if (action === "clear") {
            if (key.textContent === 'C'){
                //calculator.dataset.firstValue = '';
                //calculator.dataset.operator = '';
                //calculator.dataset.previousKeyType = '';
                //calculator.dataset.tmpSecondValue = '';
                resetData();
            }
            else {
                key.textContent = 'C';
                //if (previousKeyType == 'calculate') {
                //    resetData();
                //}
            }

            screen.textContent = '0';
            // Add custom attribute
            calculator.dataset.previousKeyType = 'clear';
        }
        else if (action === "calculate") {
            let firstValue = calculator.dataset.firstValue;
            let secondValue = screenContent;
            const operator = calculator.dataset.operator;
            if (firstValue)
            {
                if (previousKeyType === 'calculate') {
                    firstValue = screenContent;
                    secondValue = calculator.dataset.tmpSecondValue;
                }
                screen.textContent = calculate(firstValue, operator, secondValue);
            }
            calculator.dataset.tmpSecondValue = secondValue;
            calculator.querySelector('[data-action=clear]').textContent = 'C';
            // Add custom attribute
            calculator.dataset.previousKeyType = 'calculate';
        }
        else if (!action)//number
        {
            if (screenContent === '0' || previousKeyType === 'operator' ||
                previousKeyType === 'calculate')
            {
                screen.textContent = keyContent;
            }
            else
            {
                screen.textContent += keyContent;
            }
            if (previousKeyType === 'calculate') {
                resetData();
            }
            // Add custom attribute
            calculator.dataset.previousKeyType = 'number';
        }
    }
});

const calculate = (value1, operator, value2) => {
    let resultString = '';
    let resultNum;
    let FirstNum = parseFloat(value1);
    let SecondNum = parseFloat(value2);
    if (operator === 'add') {
        resultNum = FirstNum + SecondNum;
    } else if (operator === 'subtract') {
        resultNum = FirstNum - SecondNum;
    } else if (operator === 'multiply') {
        resultNum = FirstNum * SecondNum;
    } else if (operator === 'divide') {
        resultNum = FirstNum / SecondNum;
    }
    resultString = resultNum;
    return resultNum;
}

const resetData = () => {
    calculator.dataset.firstValue = '';
    calculator.dataset.operator = '';
    calculator.dataset.previousKeyType = '';
    calculator.dataset.tmpSecondValue = '';
}