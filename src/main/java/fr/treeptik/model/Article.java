package fr.treeptik.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Article {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String titre;
	private String chapeau;
	private String contenu;


	@Transient
	private boolean enLigne;
	
	@Temporal(TemporalType.DATE)
	private Date date;

	@OneToMany(mappedBy="article")
	private List<Commentaire> commentaires;

	@ManyToOne(fetch = FetchType.LAZY)
	private Auteur auteur;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Categorie categorie;

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Article(int id, String titre, String chapeau, Date date,
			boolean enLigne, Auteur auteur) {
		super();
		this.id = id;
		this.titre = titre;
		this.chapeau = chapeau;
		this.date = date;
		this.enLigne = enLigne;
		this.auteur = auteur;
	}

	public Article() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getChapeau() {
		return chapeau;
	}

	public void setChapeau(String chapeau) {
		this.chapeau = chapeau;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isEnLigne() {
		return enLigne;
	}

	public void setEnLigne(boolean enLigne) {
		this.enLigne = enLigne;
	}

	public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}
	
	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
	
	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auteur == null) ? 0 : auteur.hashCode());
		result = prime * result
				+ ((categorie == null) ? 0 : categorie.hashCode());
		result = prime * result + ((chapeau == null) ? 0 : chapeau.hashCode());
		result = prime * result
				+ ((commentaires == null) ? 0 : commentaires.hashCode());
		result = prime * result + ((contenu == null) ? 0 : contenu.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + (enLigne ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (auteur == null) {
			if (other.auteur != null)
				return false;
		} else if (!auteur.equals(other.auteur))
			return false;
		if (categorie == null) {
			if (other.categorie != null)
				return false;
		} else if (!categorie.equals(other.categorie))
			return false;
		if (chapeau == null) {
			if (other.chapeau != null)
				return false;
		} else if (!chapeau.equals(other.chapeau))
			return false;
		if (commentaires == null) {
			if (other.commentaires != null)
				return false;
		} else if (!commentaires.equals(other.commentaires))
			return false;
		if (contenu == null) {
			if (other.contenu != null)
				return false;
		} else if (!contenu.equals(other.contenu))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (enLigne != other.enLigne)
			return false;
		if (id != other.id)
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", titre=" + titre + ", chapeau="
				+ chapeau + ", contenu=" + contenu + ", enLigne=" + enLigne
				+ ", date=" + date + ", commentaires=" + commentaires
				+ ", auteur=" + auteur + ", categorie=" + categorie + "]";
	}



	
}
