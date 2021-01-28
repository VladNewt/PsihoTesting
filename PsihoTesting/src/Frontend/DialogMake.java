package Frontend;

import java.text.ParseException;

import javax.swing.JMenu;

public class DialogMake {
	private Registration registr;
	private Autorization autoriz;
	private PaintResult paintres;
	private NewDepart departadd;
	private NewPossitions possit;
	
	public DialogMake() {
		registr = new Registration();
		autoriz = new Autorization();
		paintres = new PaintResult();
		departadd = new NewDepart();
		possit = new NewPossitions();
	}
	
	public void RegistrCreate() throws ParseException {
		registr.Create();
	}
	
	public void AutorizCreate(JMenu menu) {
		autoriz.Create(menu);
	}
	
	public void ResultView() {
		paintres.Create();
	}
	
	public void NewDepart() {
		departadd.Create();
	}
	
	public void NewPossitions() {
		possit.Create();
	}

}
