// anderer Approach

package de.gleggdeathscreen;

import java.util.Random;

public class GleggDeathScreen {

	static Random random = new Random();

	static String[] sprueche = {
			"Einigermaßen gestorben.",
			"Du musst copen.",
			"Skill Issue, du PenisT.",
			"Nicht aufbauschen.",
			"Stabiler Death-Approach.",
			"GOEY.",
			"Erstmal elaborieren.",
			"Tod? Finde ich.",
			"Einigersarcel.",
			"Absolut bodenloser Approach.",
			"Das war jetzt nicht GOEY.",
			"Du wurdest wegapproacht.",
			"Respawn und cope.",
			"Wer stirbt denn so?",
			"Einigermaßen peinlich.",
			"Skill wurde nicht gefunden.",
			"Da muss man erstmal elaborieren.",
			"Du hast den Tod nicht verstanden.",
			"Massiver Cope-Moment.",
			"Der Approach war fragwürdig.",
			"Minecraft hat dich hopsgenommen.",
			"Das Finanzamt hat dich gepfändet.",
			"GOEY.exe funktioniert nicht mehr.",
			"Du wurdest offiziell gecoped.",
			"Todesursache: Skill Issue.",
			"Einigermaßen ungünstig.",
			"Dieser Tod ist Einigersarcel.",
			"Du bist nicht mehr im Approach.",
			"Bitte nicht aufbauschen, du PenisT.",
			"Gleggmire hätte das überlebt."
	};

	public static String zufall() {
		return sprueche[random.nextInt(sprueche.length)];
	}
}