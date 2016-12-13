import java.io.File;

/**
 * Created by alex on 12/13/2016.
 */
public enum FileManager
{
    MAIN_FILE,
    TEMP_FILE,
    UNDO_FILE;

    File file;

    public void setFile(File file)
    {
        this.file = file;
    }

    public File getFile()
    {
        return file;
    }
}
