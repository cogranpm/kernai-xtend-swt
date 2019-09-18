package windowbuilder;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.PojoObservables;


public class SampleBindingController {
	private SampleBinding m_sampleBinding;
	private DataBindingContext m_bindingContext;
	private windowbuilder.SampleBean sampleBean = new windowbuilder.SampleBean();

	public SampleBindingController(SampleBinding sampleBinding, windowbuilder.SampleBean newSampleBean) {
		m_sampleBinding = sampleBinding;
		setSampleBean(newSampleBean);
	}

	public SampleBindingController(SampleBinding sampleBinding) {
		m_sampleBinding = sampleBinding;
		if (sampleBean != null) {
			m_bindingContext = initDataBindings();
		}
	}

	private DataBindingContext initDataBindings() {
		IObservableValue myNameObserveWidget = SWTObservables.observeText(m_sampleBinding.getMyNameText(), SWT.Modify);
		IObservableValue myNameObserveValue = PojoObservables.observeValue(sampleBean, "myName");
		//
		DataBindingContext bindingContext = new DataBindingContext();
		//
		bindingContext.bindValue(myNameObserveWidget, myNameObserveValue, null, null);
		//
		return bindingContext;
	}

	public windowbuilder.SampleBean getSampleBean() {
		return sampleBean;
	}

	public void setSampleBean(windowbuilder.SampleBean newSampleBean) {
		setSampleBean(newSampleBean, true);
	}

	public void setSampleBean(windowbuilder.SampleBean newSampleBean, boolean update) {
		sampleBean = newSampleBean;
		if (update) {
			if (m_bindingContext != null) {
				m_bindingContext.dispose();
				m_bindingContext = null;
			}
			if (sampleBean != null) {
				m_bindingContext = initDataBindings();
			}
		}
	}
}