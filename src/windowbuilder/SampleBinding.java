package windowbuilder;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class SampleBinding extends Composite {

	private SampleBindingController m_controller;
	private Text myNameText;

	public SampleBinding(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(2, false));

		new Label(this, SWT.NONE).setText("MyName:");

		myNameText = new Text(this, SWT.BORDER | SWT.SINGLE);
		myNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		m_controller = new SampleBindingController(this);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public Text getMyNameText() {
		return myNameText;
	}

}
