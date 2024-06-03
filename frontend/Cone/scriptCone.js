

// url -> da api com as rotas
// nesse caso ai eu vou fazer varias requets
// uma pra cada troço que eu quero 

// form

async function calcular() {
    reqArea = await fetch("AAAAAAAAAAA/cone/area", data)
    area = reqArea.json()

    reqCircunferencia = await fetch("AAAAAAAAAAA/cone/circunferencia", data)
    circunferencia = reqCircunferencia.json()

    reqVolume = await fetch("AAAAAAAAAAA/cone/volume", data)
    volume = reqVolume.json()
    

    queryselector(#resposta).innerHTML = `<p> Área: ${area} <br>
                                        Circunferência: ${circunferencia} <br>
                                        Volume: ${volume} <br>`
}