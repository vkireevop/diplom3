const questions = [
    {
        question: "Ахиллесова пята",
        answers: [
            "Уязвимое место",
            "Неизвестная местность",
            "Мозоли на пятках",
        ],
        correct: 1,
    },
    {
        question: "Без году неделя",
        answers: [
            "Очень недолго",
            "Очень долго",
            "Некоторое время",
        ],
        correct: 1,
    },
    {
        question: "Белая ворона",
        answers: [
            "О человеке, который не похож на окружающих",
            "О человеке, который ничего не умеет делать",
            "Необычная птица",
        ],
        correct: 1,
    },
    {
        question: "Белое пятно",
        answers: [
            "Неизученное",
            "Непонятное",
            "Нецветное",
        ],
        correct: 1,
    },
    {
        question: "Белые мухи",
        answers: [
            "Снег",
            "Тополиный пух",
            "Мухи, которые выросли без света",
        ],
        correct: 1,
    },
    {
        question: "Беречь как зеницу ока",
        answers: [
            "Тщательно охранять",
            "Оставлять без присмотра",
            "Передать незнакомцу",
        ],
        correct: 1,
    },
    {
        question: "Битый час",
        answers: [
            "Долгое время",
            "Потерянное время",
            "Время показа боксёрских поединков",
        ],
        correct: 1,
    },
    {
        question: "Бить баклуши",
        answers: [
            "Бездельничать",
            "Заниматься неотложными делами",
            "Искать повод для драки",
        ],
        correct: 1,
    },
    {
        question: "Боевое крещение",
        answers: [
            "Первое участие в бою",
            "Передача опыта молодым",
            "Обряд посвящения в воины",
        ],
        correct: 1,
    },
    {
        question: "Боком вышло",
        answers: [
            "Не так, как хотелось бы",
            "Об узком пространстве",
            "О завершенном деле",
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
    //question.answers.sort(() => Math.random() - 0.5);

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