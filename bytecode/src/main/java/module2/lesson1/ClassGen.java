package module2.lesson1;

public class ClassGen {

    public static void main(final String... args) throws Exception {
        final String path = args[0];
        final byte[] byteCode = new ClassGen().generateSummatorClass();
        try (FileOutputStream stream = new FileOutputStream(path)) {
            stream.write(byteCode);
        }
    }

    private byte[] generateSummatorClass() {
        final ClassWriter cw = new ClassWriter(0);
        cw.visit(51,
                Opcodes.ACC_PUBLIC,
                "Summator",
                null,
                "java/lang/Object",
                null);
        generateDefaultConstructor(cw);
        generateSummMethod(cw);
        cw.visitEnd();
        return cw.toByteArray();
    }

    private void generateDefaultConstructor(final ClassWriter cw) {
        final MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
        mv.visitCode();
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(1, 1);
        mv.visitEnd();
    }

    private void generateSummMethod(final ClassWriter cw) {
        final MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC,
                "sum", // method name
                "(II)I", // method descriptor
                null,    // exceptions
                null);   // method attributes
        mv.visitCode();
        // BEGIN (write your solution here)

        // END
        mv.visitEnd();
    }
}
