const questions = [
    {
        question: "Учитель спрашивает ученика: - Признавайся честно, кто писал тебе домашнее сочинение?",
        answers: [
            "- Честное слово,  не знаю,  семья у нас большая,  а я рано лег  спать...",
            "- А если я дал честое слово молчать об этом?",
            "- Честное слово, я сам... списывал...",
        ],
        correct: 3,
    },
    {
        question: "Учитель объяснил новый урок и спрашивает: - Вопросы есть? - Есть! - кричат сразу несколько учеников. - Задавайте.",
        answers: [
            "- Скоро будет звонок?",
            "- А про что вы говорили?",
            "- А если Вы не ответите, то поставите себе 2 (нам 5)?",
        ],
        correct: 3,
    },
    {
        question: "Учитель хвалит ученика: - Миша,  у тебя замечательное сочинение! Но скажи, пожалуйста, почему ты его не окончил?",
        answers: [
            "- Потому что у папы больше не было времени...",
            "- А у меня не было такого замечательного конца.",
            "- Ну... Это уже совсем другая история.",
        ],
        correct: 3,
    },
    {
        question: `  На уроке вежливости. Учительница спрашивает:
        - Иванов,  скажи,  как называется человек, который много гово-
          рит, и говорит даже тогда, когда его никто не слушает?
        `,
        answers: [
            `- Учитель, Марья Ивановна! - отвечает Иванов.            `,
            `- Болтун.            `,
            `- Что,  Марья Ивановна? Я тут говорил кое-что и не слышал воп-  роса!            `,
        ],
        correct: 3,
    },
    {
        question: `  Учительница спрашивает первоклассника:
        - Почему ты ешь на уроке?
        - Жаль терять время на переменке.
        - Мама говорит,  что за едой должно быть тихо и нельзя  отвле-
          каться. А Вы то же самое говорите на уроке!
        `,
        answers: [
            `- Вы говорите,  что на уроке должно быть тихо и нельзя  отвлекаться. Мама то же самое говорит про еду!            `,
            `- Чтобы как-то дожить до переменки.            `,
            `- Это у меня получается лучше, чем писать и читать!            `,
        ],
        correct: 3,
    },
    {
        question: `  Идет урок истории. Молодая учительница спрашивает:
        - Дети, скажите, кто взял Бастилию? Иванов.
        - Не знаю.
        - Петров.
        - Не знаю.
        - Сидоров.
        - Не знаю.
          Учительница расстроилась и побежала к директору:
        - Ну что это за класс. Ни один не ответил, кто взял Бастилию!
        `,
        answers: [
            `- Не расстраивайтесь, - утешает ее директор, - они поиграют, и  поставят на место!            `,
            `  Директор смеется:- Да у нас ее никогда и не было!            `,
            `  Директор вздыхает:            `,
        ],
        correct: 3,
    },
    {
        question: `- Ничего! Побудете в школе, сколько они, и сами забудете!
        48.
          Вовочка спорит с учителем:
        - Я не думаю, что заслужил ""двойку"" за свое сочинение!
          Учитель:
        `,
        answers: [
            `- Я тоже так не думаю, но более низкой оценки не существует!            `,
            `- А ты подумай!            `,
            `- Почему же? По баллу за каждое предложение:  "Первое апреля" и "Сочинение"!            `,
        ],
        correct: 3,
    },
    {
        question: `  Учитель:
        - Что вы можете сказать о собаке?
        - Она очень похожа на ученика!
        - Почему?
        `,
        answers: [
            `- Все понимает, а сказать не может!            `,
            `- Все время прислушивается, что ей подскажут, что делать даль-  ше!            `,
            `- Помыть уши для нее тоже проблема.            `,
        ],
        correct: 3,
    },
    {
        question: `  Первоклассник с увлечением читает книгу о Северном  полюсе.
        Потом отрывает глаза от книги и мечтательно смотрит вдаль.
        Мама его спрашивает:
      - О чем ты задумался?
      - Я бы хотел, чтобы мы всегда жили на Северном полюсе.
      - Но почему? - удивляется мать. - Там ведь очень холодно.
      `,
        answers: [
            `- Вот именно поэтому.  Ты представляешь, сколько раз из-за хо-  лодов там отменяют занятия в школе!..            `,
            `- Зато там такая длинная ночь - вот выспаться можно!!!            `,
            `- Ничего страшного, включим отопление.            `,
        ],
        correct: 3,
    },
    {
        question: `  Учитель спрашивает ученика:
        - Почему уроки за тебя всегда делает отец?
        `,
        answers: [
            `- А у мамы никогда нет свободного времени.            `,
            `- А у меня никогда нет свободного времени.            `,
            `- А откуда вы знаете? Ваш отец тоже делал за Вас уроки?            `,
        ],
        correct: 3,
    },
];

// Перемешать массив вопросов
questions.sort(() => Math.random() - 0.5);

const questionElement = document.getElementById("question");
const answer1Element = document.getElementById("answer-1");
const answer2Element = document.getElementById("answer-2");
const answer3Element = document.getElementById("answer-3");
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

const questionsValue = localStorage.getItem("questions");

function showQuestion() {
    const question = questions[currentQuestion];

    // Перемешать массив ответов
    //question.answers.sort(() => Math.random() - 0.5);

    questionElement.textContent = question.question;
    answer1Element.textContent = question.answers[0];
    answer2Element.textContent = question.answers[1];
    answer3Element.textContent = question.answers[2];
    questionNumber.textContent = `Вопрос ${currentQuestion + 1} из ${questionsValue}`;
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

    if (currentQuestion < questionsValue) {
      showQuestion();
    } else {
      stopTimer();
      modal.style.visibility = "visible";
      result.textContent = `Правильных ответов(%): ${Math.round((score / questionsValue) * 100)}%`;
      time.textContent = `Время тренинга: ${hours}:${minutes.toString().padStart(2, 0)}:${seconds.toString().padStart(2, 0)}`;
      avgTime.textContent = `Среднее время ответа(сек): ${seconds2 / questionsValue}`;
      efficiency.textContent = `Эффективность: ${Math.round((score / questionsValue) * 100) / (seconds2 / questionsValue)}`;
      calculateGrade();
    }
  });
});

function calculateGrade() {
    const percentage = (score / questionsValue) * 100;
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
  window.location.href = "../Pages/menu.html";
});