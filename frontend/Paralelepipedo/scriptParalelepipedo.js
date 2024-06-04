// url -> da api com as rotas
// nesse caso ai eu vou fazer varias requets
// uma pra cada troço que eu quero 

async function calcular() {
    // Get the input values
    const altura = document.getElementById("alturaPrll").value;
    const largura = document.getElementById("larguraPrll").value;
    const comprimento = document.getElementById("comprimentoPrll").value;

    // Construct the query parameters
    const queryParams = new URLSearchParams({
        altura: parseFloat(altura),
        largura: parseFloat(largura),
        comprimento: parseFloat(comprimento)
    });

    // Clear previous responses
    document.getElementById("resposta").innerText = '';
    document.getElementById("error").innerText = '';

    try {
        // Make the GET request
        const responseArea = await fetch(`/prll/area?${queryParams}`);
        const responseVolume = await fetch(`/prll/volume?${queryParams}`);
        const responseDiagonal = await fetch(`/prll/diagonal?${queryParams}`);

        // Check if the response is successful
        if (!response.ok) {
            const errorData = await response.json();
            throw new Error(errorData.message || 'Unknown error');
        }

        // Get the JSON response
        const dataArea = await responseArea.json();
        const dataCircunferencia = await responseCircunferencia.json();
        const dataDiagonal = await responseDiagonal.json();

        // Display the volume in the resposta paragraph
        document.getElementById("resposta").innerText = `Área: ${dataArea} <br>
                                                        Circunferência: ${dataCircunferencia} <br>
                                                        Diagonal: ${dataDiagonal} <br>`;
    } catch (error) {
        // Display the error message in the error paragraph
        document.getElementById("error").innerText = `Erro: ${error.message}`;
    }
}