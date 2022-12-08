import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import ru.itis.decoder.fano.decodeFano

private class FanoTest {
    @Test
    fun `empty dictionary test return error`() {
        assertThrows<IllegalStateException> {
            decodeFano("10010", mutableMapOf())
        }
    }

    @Test
    fun `success test return decoded code`() {
        val expectedResult = "edddc"
        val inputTest = "1110110110110101"
        val fanoMap = mutableMapOf("a" to 0.6, "b" to 0.1, "c" to 0.09, "d" to 0.08, "e" to 0.065, "f" to 0.065)
        assertEquals(expectedResult, decodeFano(inputTest, fanoMap))
    }
    @Test
    fun `success test with one element return decoded code`() {
        val expectedResult = "aaa"
        val inputTest = "000"
        val fanoMap = mutableMapOf("a" to 1.0)
        assertEquals(expectedResult, decodeFano(inputTest, fanoMap))
    }
    @Test
    fun `success test with two element return decoded code`() {
        val expectedResult = "ab"
        val inputTest = "01"
        val fanoMap = mutableMapOf("a" to 0.5, "b" to 0.5)
        assertEquals(expectedResult, decodeFano(inputTest, fanoMap))
    }

    @Test
    fun `message can not be decoded return error`() {
        assertThrows<IllegalStateException> {
            decodeFano("10", mutableMapOf("a" to 0.6, "b" to 0.1, "c" to 0.09, "d" to 0.08, "e" to 0.065, "f" to 0.065))
        }
    }
}