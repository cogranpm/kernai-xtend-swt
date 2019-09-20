package com.kernai.ui

import java.util.List
import org.eclipse.jface.action.MenuManager
import org.eclipse.jface.action.StatusLineManager
import org.eclipse.jface.action.ToolBarManager
import org.eclipse.jface.window.ApplicationWindow
import org.eclipse.swt.SWT
import org.eclipse.swt.graphics.Point
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Control
import org.eclipse.swt.widgets.Display
import org.eclipse.swt.widgets.Shell
import org.eclipse.swt.layout.FillLayout
import org.eclipse.swt.widgets.Label

class XMainWindow extends ApplicationWindow{
	String name
	
	new(){
		super(null)
		addToolBar(SWT.FLAT.bitwiseOr(SWT.WRAP))
		addMenuBar()
		addStatusLine()
		
	}
	
	def static void main(String[] args) {
		println('Hello World!')
		try {
			var mainWindow = new XMainWindow()
			mainWindow.blockOnOpen = true
			mainWindow.open()
		}
		catch(Exception ex)
		{
			
		}
	}
	
	override protected createContents(Composite parent) {
		var container = new Composite(parent, SWT.NONE)
		container.layout = new FillLayout(SWT.HORIZONTAL)
		var lblLabel = new Label(container, SWT.NONE)
		lblLabel.text = "Kernai 1"
		return container
		
	}
	
	override protected createMenuManager() {
		var menuManager = new MenuManager("menu")
		return menuManager
	}
	
	override protected createToolBarManager(int style) {
		var toolbarManager = new ToolBarManager(style)
		return toolbarManager
	}
	
	override protected createStatusLineManager(){
		var statusLineManager = new StatusLineManager()
		return statusLineManager
	}
	
	
	override protected configureShell(Shell newShell){
		super.configureShell(newShell)
		newShell.text = "Kernai"
	}
	
	override protected getInitialSize() {
		return new Point(564, 487);
	}
	
	
	def String first(List<String> elements) {
		elements.get(0)
	}
}