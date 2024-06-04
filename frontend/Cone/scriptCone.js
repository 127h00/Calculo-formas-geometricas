// url -> da api com as rotas
// nesse caso ai eu vou fazer varias requets
// uma pra cada troço que eu quero 

async function calcular() {
    // Get the input values
    const altura = document.getElementById("alturaCone").value;
    const raio = document.getElementById("raioCone").value;
    const geratriz = document.getElementById("geratrizCone").value;

    // Construct the query parameters
    const queryParams = new URLSearchParams({
        altura: parseFloat(altura),
        raio: parseFloat(raio),
        geratriz: parseFloat(geratriz)
    });

    // Clear previous responses
    document.getElementById("resposta").innerText = '';
    document.getElementById("error").innerText = '';

    try {
        // Make the GET request
        const responseArea = await fetch(`/cone/area?${queryParams}`);
        const responseCircunferencia = await fetch(`/cone/circunferencia?${queryParams}`);
        const responseVolume = await fetch(`/cone/volume?${queryParams}`);

        // Check if the response is successful
        if (!response.ok) {
            const errorData = await response.json();
            throw new Error(errorData.message || 'Unknown error');
        }

        // Get the JSON response
        const dataArea = await responseArea.json();
        const dataCircunferencia = await responseCircunferencia.json();
        const dataVolume = await responseVolume.json();

        // Display the volume in the resposta paragraph
        document.getElementById("resposta").innerText = `Área: ${dataArea} <br>
                                                        Circunferência: ${dataCircunferencia} <br>
                                                        Volume: ${dataVolume} <br>`;
    } catch (error) {
        // Display the error message in the error paragraph
        document.getElementById("error").innerText = `Erro: ${error.message}`;
    }
}