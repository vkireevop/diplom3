const questions = [
    {
        question: 
            `У крыльца лохматый пёс
            Лёг, уткнувши в лапы нос.
            Тихо, мирно он сопит."
        `,
        answers: [
            "Может, дремлет, может, спит.",
            "А он боится кошки.",
            "В огород прохода нет.",
            "Нелегко сорвать цветок.",
            "Да боюсь сердитой кошки.",
            "Не знаю",
        ],
        correct: 1,
    },
    {
        question: 
        `Буря мглою небо кроет,
        Вихри снежные крутя;
        То, как зверь, она завоет,
        `,
        answers: [
            "То заплачет, как дитя.",
            "После всех трудов.",
            "Ёлку из лесу привез.",
            "И лес оденется листвою!",
            "Лишь хватило бы небес.",
            "Не знаю",
        ],
        correct: 1,
    },
    {
        question:
        `Рвать цветы легко и просто
        Детям маленького роста,
        Но тому, кто так высок,
        `,
        answers: [
            "Нелегко сорвать цветок.",
            "В огород прохода нет.",
            "Нелегко сорвать цветок.",
            "Да боюсь сердитой кошки.",
            "Шапка на макушке.",
            "Не знаю",
        ],
        correct: 1,
    },
    {
        question:
        `Воробей, чего ты ждешь?
        Крошек хлебных не клюёшь?
        - Я давно заметил крошки,
        `,
        answers: [
            "Да боюсь сердитой кошки.",
            "В огород прохода нет.",
            "Нелегко сорвать цветок.",
            "Да боюсь сердитой кошки.",
            "Шапка на макушке.",
            "Не знаю",
        ],
        correct: 1,
    },
    {
        question:
        `Дождик вылился из тучки,
        Вымыл ёжику колючки,
        Еж доволен: сыт, умыт,
        `,
        answers: [
            "На кроватке сладко спит.",
            "В огород прохода нет.",
            "Нелегко сорвать цветок.",
            "Да боюсь сердитой кошки.",
            "Шапка на макушке.",
            "Не знаю",
        ],
        correct: 1,
    },
    {
        question:
        `Целый день поёт щегол
        В клетке на окошке.
        Третий год ему пошёл,
        `,
        answers: [
            "А он боится кошки.",
            "В огород прохода нет.",
            "Нелегко сорвать цветок.",
            "Да боюсь сердитой кошки.",
            "Шапка на макушке.",
            "Не знаю",
        ],
        correct: 1,
    },
    {
        question:
        `Спит на льдине целый день
        Толстый маленький тюлень.
        У ленивого растяпы
        `,
        answers: [
            "Превратились в ласты лапы.",
            "В огород прохода нет.",
            "Нелегко сорвать цветок.",
            "Да боюсь сердитой кошки.",
            "Шапка на макушке.",
            "Не знаю",
        ],
        correct: 1,
    },
    {
        question:
        `Солнце ласково смеётся,
        Светит ярче, горячей.
        И с пригорка звонко льётся
        `,
        answers: [
            "Разговорчивый ручей.",
            "В огород прохода нет.",
            "Нелегко сорвать цветок.",
            "Да боюсь сердитой кошки.",
            "Шапка на макушке.",
            "Не знаю",
        ],
        correct: 1,
    },
    {
        question:
        `Учит выдра-мать выдрят,
        Как ловить в реке щурят.
        Чтоб нырять за рыбкой ловко,
        `,
        answers: [
            "Малышам нужна сноровка.",
            "В огород прохода нет.",
            "Нелегко сорвать цветок.",
            "Да боюсь сердитой кошки.",
            "Шапка на макушке.",
            "Не знаю",
        ],
        correct: 1,
    },
    {
        question:
        `Вышли волки на охоту,
        Бродят стаей по болоту.
        Между прочим, говорят,
        `,
        answers: [
            "Волки ягоды едят.",
            "Темно-голубые?",
            "Плесень может вырасти.",
            "Своими руками.",
            "В саду на скамейке.",
            "Не знаю",
        ],
        correct: 1,
    },
]

// Перемешать массив вопросов
questions.sort(() => Math.random() - 0.5);

const questionElement = document.getElementById("question");
const answer1Element = document.getElementById("answer-1");
const answer2Element = document.getElementById("answer-2");
const answer3Element = document.getElementById("answer-3");
const answer4Element = document.getElementById("answer-4");
const answer5Element = document.getElementById("answer-5");
const answer6Element = document.getElementById("answer-6");
const questionNumber = document.getElementById("question-number");

const modal = document.getElementById("modal");
const result = document.getElementById("result");
const efficiency = document.getElementById("efficiency");
const time = document.getElementById("time");
const avgTime = document.getElementById("avg-time");
const grade = document.getElementById("grade");
const timer = document.getElementById("timer");
const closeModalButton = document.getElementById("close-modal");

let currentQuestion = 0;
let score = 0;
let seconds = 0;
let seconds2 = seconds;
let minutes = 0;
let hours = 0;
let interval;

function showQuestion() {
    const question = questions[currentQuestion];

    // Перемешать массив ответов
    question.answers.sort(() => Math.random() - 0.5);

    questionElement.textContent = question.question;
    answer1Element.textContent = question.answers[0];
    answer2Element.textContent = question.answers[1];
    answer3Element.textContent = question.answers[2];
    answer4Element.textContent = question.answers[3];
    answer5Element.textContent = question.answers[4];
    answer6Element.textContent = question.answers[5];
    questionNumber.textContent = `Вопрос ${currentQuestion + 1} из ${questions.length}`;
}

function startTimer() {
    interval = setInterval(() => {
      seconds++;
      seconds2++;
      if (seconds === 60) {
        seconds = 0;
        minutes++;
      }
      if (minutes === 60) {
          minutes = 0;
          hours++;
      }
  
      timer.textContent = `Время: ${hours}:${minutes.toString().padStart(2, 0)}:${seconds.toString().padStart(2, 0)}`;
    }, 1000);
}
  
function stopTimer() {
    clearInterval(interval);
}
  
showQuestion();
startTimer();

const buttons = document.querySelectorAll("#buttons button");
buttons.forEach((button) => {
  button.addEventListener("click", () => {
    const answer = button.textContent;
    if (answer === questions[currentQuestion].answers[questions[currentQuestion].correct - 1]) {
      score++;
    }

    currentQuestion++;

    if (currentQuestion < questions.length) {
      showQuestion();
    } else {
      stopTimer();
      modal.style.visibility = "visible";
      result.textContent = `Правильных ответов(%): ${Math.round((score / questions.length) * 100)}%`;
      time.textContent = `Время тренинга: ${hours}:${minutes.toString().padStart(2, 0)}:${seconds.toString().padStart(2, 0)}`;
      avgTime.textContent = `Среднее время ответа(сек): ${seconds2 / questions.length}`;
      efficiency.textContent = `Эффективность: ${Math.round((score / questions.length) * 100) / (seconds2 / questions.length)}`;
      calculateGrade();
    }
  });
});

function calculateGrade() {
    const percentage = (score / questions.length) * 100;
    if (percentage >= 90) {
      grade.textContent = "Оценка: Отлично";
    } else if (percentage >= 70) {
      grade.textContent = "Оценка: Хорошо";
    } else if (percentage >= 50) {
      grade.textContent = "Оценка: Удовлетворительно";
    } else {
      grade.textContent = "Оценка: Неудовлетворительно";
    }
}

closeModalButton.addEventListener("click", () => {
  modal.style.visibility = "hidden";
  window.location.reload();
  window.location.href = "../Pages/menu-stikhi.html";
});