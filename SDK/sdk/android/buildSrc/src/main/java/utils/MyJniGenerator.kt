package utils

import java.io.File

class MyJniGenerator : JniGenerator() {
    val boardModel: Model = Model(
        javaSrc = "talwtn/src/main/java",
        namespace = "webrtc::jni",
        outPutDir = "talwtn/gen/cpp"
    )

    fun appendBoard(packageName: String, fileName: String): MyJniGenerator {
        super.append(boardModel, packageName, fileName)
        return this
    }

    override fun cleanJNI() {
        File(projectDir, boardModel.outPutDir).apply {
            if (!exists()) {
                return
            }
            absoluteFile.deleteRecursively()
        }
    }
}