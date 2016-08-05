package edu.umkc.vikas.myplugin.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.jface.dialogs.MessageDialog;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;
import edu.umkc.vikas.myplugin.*;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class SampleHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public SampleHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		MessageDialog.openInformation(
				window.getShell(),
				"My Plug-ins",
				"You are about to play Tetris game");//Copy and replace.
		
		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor("edu.umkc.vikas.myplugin.point1");//Change to fit your own
		IConfigurationElement[] config2 = Platform.getExtensionRegistry()
				.getConfigurationElementsFor("edu.umkc.vikas.myplugin.point2");
		try {
				
			IConfigurationElement e2 = config2[0];
				System.out.println("Evaluating extension2");
				Object o2 = e2.createExecutableExtension("class");
				
			
			IConfigurationElement e = config[0];
				System.out.println("Evaluating extension");
				 Object o = e.createExecutableExtension("class");
				if (o instanceof Clock) {
					//greetings+=((Clock) o).setCyclesPerSecond(100)+"\n";
					Tetris t = new Tetris(o, o2);
					t.startGame();
				}
			
			
		} catch (CoreException ex) {
			System.out.println(ex.getMessage());
		
		}
		return null;
	}

	//Copy and paste the following method
  
}
