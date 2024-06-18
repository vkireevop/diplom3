const questions = [
    {
        question: "Бог да город, чёрт да деревня.",
        answers: [
            "1. Город во всех отношениях лучше деревни.",
            "2. Городские власти лучше заботятся о населении.",
            "3. В деревне люди менее религиозны.",
        ],
        correct: 1,
    },
    {
        question: "Бог даст и в окно подаст.",
        answers: [
            "1. Удача сама придёт.",
            "2. Человек без заботы не останется.",
            "3. Бог всемогущ.",
        ],
        correct: 1,
    },
    {
        question: "Бог не выдаст, свинья не съест.",
        answers: [
            "1. Ничего плохого не случится.",
            "2. Никто ничего не узнает.",
            "3. Доносчиков не любит никто.",
        ],
        correct: 1,
    },
    {
        question: "Брань на вороту не виснет.",
        answers: [
            "1. Обидные слова забываются, их можно стерпеть.",
            "2. Ругаться не вредно.",
            "3. Плохое человек не забывает.",
        ],
        correct: 1,
    },
    {
        question: "Был конь, да изъездился.",
        answers: [
            "1. Об утратившем свои былые достоинства.",
            "2. Всему приходит конец.",
            "3. Конь стал старым.",
        ],
        correct: 1,
    },
    {
        question: "Был муж, да объелся груш.",
        answers: [
            "1. Не стало мужа.",
            "2. Очень жадный муж.",
            "3. Плохо мужу.",
        ],
        correct: 1,
    },
    {
        question: "Была бы спина – найдётся и вина.",
        answers: [
            "1. Было бы кого наказать, а повод всегда найдётся.",
            "2. Если виноват, заслуживаешь наказания.",
            "3. Каждый в чём-то виноват.",
        ],
        correct: 1,
    },
    {
        question: "Была бы шея, а хомут найдётся",
        answers: [
            "1. Было бы кому работать, а работа всегда отыщется.",
            "2. Каждый должен заниматься тем, что ему нравится.",
            "3. Каждого надо заставить работать.",
        ],
        correct: 1,
    },
    {
        question: "Быть бычку на верёвочке.",
        answers: [
            "1. Придётся расплачиваться за что-либо.",
            "2. Мошенник будет пойман.",
            "3. Бычка обязательно надо привязывать.",
        ],
        correct: 1,
    },
    {
        question: "В подплечье и помело – большак.",
        answers: [
            "1. Каждый на своём месте важен.",
            "2. Довольствуйся тем, что есть.",
            "3. В маленькой печке ничего не помещается.",
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
  window.location.href = "../Pages/menu.html";
});