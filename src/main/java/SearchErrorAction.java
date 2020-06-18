import com.intellij.ide.BrowserUtil;
import com.intellij.lang.Language;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.net.URI;
import java.net.URISyntaxException;

public class SearchErrorAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        /*URI uri = null;
        try {
            uri = new URI("https://google.com");
            Desktop desk = Desktop.getDesktop();
            desk.browse(uri);
        } catch (Exception ex) {
            ex.printStackTrace();
        }*/

        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        CaretModel caretModel = editor.getCaretModel();
        String selectedText = caretModel.getCurrentCaret().getSelectedText();

        String query = selectedText.replace(' ', '+');
        BrowserUtil.browse("https://stackoverflow.com/search?q=" + query);
    }
}
