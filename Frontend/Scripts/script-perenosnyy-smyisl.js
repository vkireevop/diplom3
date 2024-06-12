const questions = [
    {
        answers: [
            "Безграничная печаль.",
            "Безграничные просторы.",
        ],
        correct: 1,
    },
    {
        answers: [
            "Баламутить ребят.",
            "Баламутить воду.",
        ],
        correct: 1,
    },
    {
        answers: [
            "Баранка автомобиля.",
            "Маковая баранка.",
        ],
        correct: 1,
    },
    {
        answers: [
            "Бархатная травка.",
            "Бархатное платье.",
        ],
        correct: 1,
    },
    {
        answers: [
            "Бархатный голос.",
            "Бархатный костюм.",
        ],
        correct: 1,
    },
    {
        answers: [
            "Бегут волны.",
            "Бегут кросс.",
        ],
        correct: 1,
    },
    {
        answers: [
            "Беда висит над головой.",
            "Утёс висит над морем.",
        ],
        correct: 1,
    },
    {
        answers: [
            "Бедная природа.",
            "Бедный квартал.",
        ],
        correct: 1,
    },
    {
        answers: [
            "Бедное воображение.",
            "Бедная семья.",
        ],
        correct: 1,
    },
    {
        answers: [
            "Безбрежная тоска.",
            "Безбрежное море.",
        ],
        correct: 1,
    },
]

const answer1 = document.getElementById("answer-1");
const answer2 = document.getElementById("answer-2");
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

  answer1.textContent = question.answers[0];
  answer2.textContent = question.answers[1];
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