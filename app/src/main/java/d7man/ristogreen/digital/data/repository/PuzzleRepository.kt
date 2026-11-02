package d7man.ristogreen.digital.data.repository

import d7man.ristogreen.digital.R
import d7man.ristogreen.digital.data.model.Puzzle

class PuzzleRepository {
    private val puzzles: List<Puzzle> = listOf(
        Puzzle(
            id = 1,
            texts = mapOf(
                "en" to "Butterfly Bloom", "de" to "Schmetterlingsblüte",
                "es" to "Mariposa en flor", "fr" to "Papillon fleuri",
                "hi" to "फूल पर तितली", "id" to "Kupu-kupu Bunga",
                "pt" to "Borboleta na Flor", "ar" to "فراشة وزهرة",
            ),
            resId = R.drawable.butterfly_bloom,
        ),
        Puzzle(
            id = 2,
            texts = mapOf(
                "en" to "Forest Owl", "de" to "Waldkauz",
                "es" to "Búho del bosque", "fr" to "Hibou des bois",
                "hi" to "वन उल्लू", "id" to "Burung Hantu Hutan",
                "pt" to "Coruja da Floresta", "ar" to "بومة الغابة",
            ),
            resId = R.drawable.forest_owl,
        ),
        Puzzle(
            id = 3,
            texts = mapOf(
                "en" to "Forest Deer", "de" to "Waldhirsch",
                "es" to "Ciervo del bosque", "fr" to "Cerf des bois",
                "hi" to "वन हिरण", "id" to "Rusa Hutan",
                "pt" to "Cervo da Mata", "ar" to "أيل الغابة",
            ),
            resId = R.drawable.sambar_deer,
        ),
        Puzzle(
            id = 4,
            texts = mapOf(
                "en" to "Forest Parrot", "de" to "Waldpapagei",
                "es" to "Loro del bosque", "fr" to "Perroquet forestier",
                "hi" to "वन तोता", "id" to "Nuri Hutan",
                "pt" to "Papagaio da Mata", "ar" to "ببغاء الغابة",
            ),
            resId = R.drawable.forest_parrot,
        ),
        Puzzle(
            id = 5,
            texts = mapOf(
                "en" to "Red Squirrel", "de" to "Rotes Eichhörnchen",
                "es" to "Ardilla roja", "fr" to "Écureuil roux",
                "hi" to "लाल गिलहरी", "id" to "Tupai Merah",
                "pt" to "Esquilo Vermelho", "ar" to "سنجاب أحمر",
            ),
            resId = R.drawable.red_squirrel,
        ),
        Puzzle(
            id = 6,
            texts = mapOf(
                "en" to "Leaf Chameleon", "de" to "Blattchamäleon",
                "es" to "Camaleón verde", "fr" to "Caméléon feuillu",
                "hi" to "पत्ती गिरगिट", "id" to "Bunglon Daun",
                "pt" to "Camaleão Verde", "ar" to "حرباء ورقية",
            ),
            resId = R.drawable.leaf_chameleon,
        ),
        Puzzle(
            id = 7,
            texts = mapOf(
                "en" to "Red Panda", "de" to "Roter Panda",
                "es" to "Panda rojo", "fr" to "Panda roux",
                "hi" to "लाल पांडा", "id" to "Panda Merah",
                "pt" to "Panda Vermelho", "ar" to "باندا أحمر",
            ),
            resId = R.drawable.red_panda,
        ),
    )

    fun getPuzzles(): List<Puzzle> = puzzles

    fun findById(id: Int): Puzzle? = puzzles.firstOrNull { it.id == id }
}
