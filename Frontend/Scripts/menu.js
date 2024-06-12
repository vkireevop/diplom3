const instructions = [
    `Вам будет предложено прочитать текст
    и отметить в нем места,
    в которых даются ответы на вопросы,
    раположенные в конце текста.
    Те места, которые можно отмечать,
    выделены в тексте цветом.
    Чтобы отметить выделенный текст,
    нужно щёлкнуть по нему курсором мышки.`,
    `В этом тесте проводится
    несколько испытаний,
    в каждом из которых нужно
    выбрать из предложенных вариантов
    правильное окончание к показанному анекдоту.`,
    `В этом тесте предлагается ряд заданий,
    в каждом из которых нужно выбрать
    из предложенных вариантов
    верное толкование пословицы.`,
    `В этом тесте проводится несколько испытаний,
    в каждом из которых нужно выбрать
    из предложенных вариантов
    верное толкование фразеологизма.`,
    `В этом тесте предлагается ряд заданий,
    в каждом из которых нужно выбрать
    тот вариант, где слово употреблено
    в переносном смысле.`,
    `Вам будет предложено прочитать текст
    и выбрать из предложенных вариантов тот,
    который наиболее точно передаёт
    главную мысль текста.`,
];

const menuButtons = document.querySelectorAll("#menu button");
const modal = document.getElementById("modal");
const instructionTextElement = document.getElementById("instruction-text");
const closeModalAndGoToExerciseButton = document.getElementById("close-modal-and-go-to-exercise");

const poemButton = document.getElementById("poem-button");

const questionsValue = localStorage.getItem("questions");
console.log(`Количество вопросов: ${questionsValue}`);

let currentExerciseIndex = 0;

menuButtons.forEach((button, index) => {
  button.addEventListener("click", () => {
    if (button === poemButton) {
      // Если нажата кнопка "Стихи", переходим на страницу со стихами без показа инструкции
      window.location.href = button.getAttribute("data-href");
      return;
    }
    modal.style.visibility = "visible";
    instructionTextElement.textContent = instructions[index];
    currentExerciseIndex = index;
  });
});

closeModalAndGoToExerciseButton.addEventListener("click", () => {
  modal.style.visibility = "hidden";
  const href = menuButtons[currentExerciseIndex].getAttribute("data-href");
  window.location.href = href;
});