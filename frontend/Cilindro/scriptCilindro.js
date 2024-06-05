async function calcular() {
    // Get the input values
    const raio = document.getElementById("raioCilindro").value;
    const alt = document.getElementById("altCilindro").value;

    // Construct the query parameters
    const queryParams = new URLSearchParams({
        altura: parseFloat(alt),
        raio: parseFloat(raio)
    });

    // Clear previous responses
    document.getElementById("resposta").innerText = '';
    document.getElementById("error").innerText = '';

    try {
        // Make the GET request
        const areaTotal = await fetch(`http://localhost:8080/cilindro/area?${queryParams}`);
        const volume = await fetch(`http://localhost:8080/cilindro/volume?${queryParams}`);
        const perimetro = await fetch(`http://localhost:8080/cilindro/perimetro?${queryParams}`);

        // Check if the response is successful
        if (!areaTotal.ok ||!volume.ok||!perimetro.ok) {
            const errorData = await response.json();
            throw new Error(errorData.message || 'Unknown error');
        }

        // Get the JSON response
        const dataArea = await areaTotal.json();
        const dataVolume = await volume.json();
        const dataPerimetro = await perimetro.json();

        // Display the volume in the resposta paragraph
        document.getElementById("resposta").innerText = `Área: ${dataArea} 
                                                        Perimetro: ${dataPerimetro} 
                                                        Volume: ${dataVolume}`;
    } catch (error) {
        // Display the error message in the error paragraph
        document.getElementById("error").innerText = `Erro: ${error.message}`;
    }
}