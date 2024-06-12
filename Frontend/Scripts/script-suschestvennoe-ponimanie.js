const questions = [
    {
        question: `По улице шли мальчик и девочка. А впереди них шла старушка. Было очень скользко. Старушка поскользнулась и упала.
        – Подержи мои книжки! – крикнул мальчик, передал девочке свой портфель и бросился на помощь старушке.
        Когда он вернулся, девочка спросила его: «Это твоя бабушка?»
        – Нет, – отвечал мальчик.
        – Мама? – удивилась подружка.
        – Нет!
        – Ну, тетя? Или знакомая?
        – Да нет же, нет! – ответил мальчик. – Это просто старушка!
        `,
        answers: [
            "Помоги старому, сам стар будешь.",
            "Старость – не радость.",
            "Чужую беду руками разведу.",
        ],
        correct: 1,
    },
    {
        question: `Мальчик стерег овец и, будто увидав волка, стал звать: «Помогите, волк! Волк!»
        Мужики прибежали и видят: неправда. Как сделал он так и два, и три раза, случилось – и вправду набежал волк.
        Мальчик стал кричать: «Сюда, сюда скорей, волк!» Мужики подумали, что опять по-всегдашнему обманывает, – не послушали его.
        Волк видит, бояться нечего: на просторе перерезал все стадо.
        `,
        answers: [
            "Раз солгал, навек лгуном стал.",
            "В каждой шутке есть доля правды.",
            "Помощь – великое дело.",
        ],
        correct: 1,
    },
    {
        question: `Идет мужик завозом по морозу и думает: «Хорошо теперь дома, в теплой хате».
        Рыскает зверь по лесу, зябнет на морозе и думает: «Хорошо бы теперь лежать в теплом логове».
        Летела птица по поднебесью. Била птицу вьюга-метель. Думает птица: «Хорошо бы теперь сидеть в теплом гнезде».
        И человеку, и зверю, и птице тепло и привольно в своем родном углу.
        `,
        answers: [
            "Своя хатка – родная матка.",
            "Избяным теплом далеко не уйдешь.",
            "Язык до Киева доведет.",
        ],
        correct: 1,
    },
    {
        question: `Муравей спустился к ручью: захотел напиться. Волной плеснуло на муравья, и стал он тонуть.
        Голубка несла ветку. Она увидала, муравей тонет, и бросила ему ветку в ручей. Муравей сел на ветку и спасся.
        Расставил охотник сеть на голубку и хотел захлопнуть. Муравей подполз к охотнику и укусил ему ногу.
        Охотник охнул и уронил сеть. Голубка вспорхнула и улетела.
        `,
        answers: [
            "Долг платежом красен.",
            "И комар лошадь свалит, коли волк пособит.",
            "Не великое дело – великая помощь.",
        ],
        correct: 1,
    },
    {
        question: `Подошел ночью вор ко двору. Собака почуяла его и начала лаять. Вор достал хлеба и кинул собаке. Собака не взяла хлеб, бросилась на вора и стала его кусать за ноги.
        – За что ж ты меня кусаешь? Я тебе хлеба даю, — сказал вор.
        – А за то кусаю, что, пока ты хлеба не давал, я еще не знала, хороший ты или злой человек, а теперь верно знаю, что ты недобрый человек, если меня подкупить хочешь.
        `,
        answers: [
            "Бойся не ту собаку, что лает, а ту, что хвостом виляет.",
            "Ласкатель - тот же злодей.",
            "Нельзя платить злом за добро.",
        ],
        correct: 1,
    },
    {
        question: `Завелось в одном доме много мышей. Кот забрался в этот дом и стал ловить мышей. Увидали мыши, что дело плохо, и говорят: «Давайте, мыши, не будем больше сходить с потолка, а сюда к нам коту не добраться!»
        Как перестали мыши сходить вниз, кот и задумал, как бы их перехитрить.
        Уцепился он одной лапой за потолок, свесился и притворился мертвым. Одна мышь выглянула на него, да и говорит: «Нет, брат! Хоть мешком сделайся, и то не подойду».
        `,
        answers: [
            "Стреляного воробья на мякине не проведешь.",
            "Умер кот – мыши водят хоровод.",
            "Собака – обжора, а кот – сластена.",
        ],
        correct: 1,
    },
    {
        question: `Сын приехал из города к отцу в деревню. Отец сказал: «Нынче покос, возьми грабли, и пойдем, пособи мне».
        А сыну не хотелось работать, он и говорит: «Я учился наукам, а все мужицкие слова забыл; что такое грабли?»
        Только он пошел по двору, наступил на грабли; они ударили его в лоб. Тогда он и вспомнил, что такое грабли, хватился за лоб и говорит: «И что за дурак тут грабли бросил!»
        `,
        answers: [
            "Бездельника палка учит.",
            "Век живи — век учись.",
            "Кто грамоте горазд, тому не пропасть.",
        ],
        correct: 1,
    },
    {
        question: `Сошлись раз зайцы и стали плакаться на свою жизнь: «И от людей, и от собак, и от орлов, и от прочих зверей погибаем. Уж лучше раз умереть, чем в страхе жить и мучиться. Давайте утопимся!»
        И поскакали зайцы на озеро топиться. Лягушки услыхали зайцев и забултыхались в воду. Один заяц и говорит: «Стойте, ребята! Подождем топиться; вот лягушечье житье, видно, еще хуже нашего: они и нас боятся».
        `,
        answers: [
            "Не ропщи на судьбу, бывает и хуже.",
            "Не было бы счастья, да несчастье помогло.",
            "Чужая беда учит.",
        ],
        correct: 1,
    },
    {
        question: `Собака и петух пошли странствовать. Ввечеру петух уснул на дереве, а собака пристроилась у того же дерева, промеж кореньев. Как пришло время, петух запел. Лисица услыхала петуха, прибежала и стала снизу просить, чтобы он сошел к ней, будто ей хочется оказать почтенье ему за то, что у него голос хорош. Петух сказал: «Надо прежде разбудить дворника, он спит промеж кореньев. Пусть отопрет, тогда я сойду».
        Лисица стала искать дворника и забрехала. Собака живо вскочила и задала лисице трепку.
        `,
        answers: [
            "На всякого мудреца довольно простоты.",
            "Лисью ласку принимай с опаской.",
            "Дитя не плачет, мать не разумеет.",
        ],
        correct: 1,
    },
    {
        question: `Хотелось волку подобраться к жеребенку. Он подошел к табуну и говорит: «Что это у вас жеребенок один хромает? Или вы полечить не умеете? У нас, волков, такое лекарство есть, что никогда хромоты не будет».
        Кобыла одна и говорит: «А ты знаешь лечить?» «Как не знать». «Так вот полечи мне правую заднюю ногу, что-то в копытце больно».
        Волк подошел к кобыле, и, как зашел к ней сзади, она ударила его копытом.
        `,
        answers: [
            "Что живо, то и хитро.",
            "С волками жить - по-волчьи выть.",
            "Конь копытом сдачи дает.",
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