
const colors = ["Azul", "Verde", "Negro", "Lila", "Blanco", "Cian","Naranja","Turquesa","Marrón"];

        const getRandomInt = (max) => {
        return Math.floor(Math.random() * max);
        }

        const getRandomColors = (num) => {
        let contColors = 0;
        let randomColors = [];

        while (contColors < num) {
        const randomIndex = getRandomInt(colors.length);
        const newColor = colors[randomIndex];

        if (!checkElement(randomColors, newColor)) {
        randomColors[contColors] = newColor;
        contColors++;
        }
        }

        return randomColors;
        }

        const checkElement = (array, element) => {
        for (let i=0; i < array.length; i++) {
        if (array[i] === element) {
        return true;
        };
        };
        return false;
        }

        getRandomColors(4);