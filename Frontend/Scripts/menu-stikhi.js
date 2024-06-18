const instructions = [
    `В этом тесте проводится
    несколько испытаний,
    в каждом из которых нужно
    расставить в правильном порядке
    строки стихотворения.
    Для перемешения строки нужно
    зацепить её мышкой, перетащить на
    нужную вам строку и строки вставится.`,
    `В этом тесте проводится
    несколько испытаний,
    в каждом из которых нужно
    выбрать из предложенных вариантов
    правильное окончание фразы.`,
    `В этом тесте проводится
    несколько испытаний,
    в каждом из которых нужно
    выбрать из предложенных вариантов
    последнюю строку показанного
    стихотворения.`,
];

const menuButtons = document.querySelectorAll("#menu button");
const modal = document.getElementById("modal");
const instructionTextElement = document.getElementById("instruction-text");
const closeModalAndGoToExerciseButton = document.getElementById("close-modal-and-go-to-exercise");

const returnMenuButton = document.getElementById("return-menu-button");

let currentExerciseIndex = 0;

menuButtons.forEach((button, index) => {
  button.addEventListener("click", () => {
    if (button === returnMenuButton) {
        //
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