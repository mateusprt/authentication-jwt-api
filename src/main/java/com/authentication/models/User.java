package com.authentication.models;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User implements UserDetails {
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@Column(name = "confirmation_token")
	private String confirmationToken;
	
	@Column(name = "confirmation_token_sent_at")
	private Date confirmationTokenSentAt;
	
	@Column(name = "confirmed_at")
	private Date confirmedAt;
	
	@Column(name = "reset_password_token")
	private String resetPasswordToken;
	
	@Column(name = "reset_password_token_sent_at")
	private Date resetPasswordTokenSentAt;
	
	@Column
	private boolean unconfirmed;
	
	@Column(name = "created_at")
	@CreationTimestamp
	private Date createdAt;
	
	@Column(name = "updated_at")
	@UpdateTimestamp
	private Date updatedAt;

	public User() {}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(this.getRole().getName()));
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmationToken() {
		return confirmationToken;
	}

	public void setConfirmationToken(String confirmationToken) {
		this.confirmationToken = confirmationToken;
	}

	public Date getConfirmationTokenSentAt() {
		return confirmationTokenSentAt;
	}

	public void setConfirmationTokenSentAt(Date confirmationTokenSentAt) {
		this.confirmationTokenSentAt = confirmationTokenSentAt;
	}

	public Date getConfirmedAt() {
		return confirmedAt;
	}

	public void setConfirmedAt(Date confirmedAt) {
		this.confirmedAt = confirmedAt;
	}

	public String getResetPasswordToken() {
		return resetPasswordToken;
	}

	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}

	public Date getResetPasswordTokenSentAt() {
		return resetPasswordTokenSentAt;
	}

	public void setResetPasswordTokenSentAt(Date resetPasswordTokenSentAt) {
		this.resetPasswordTokenSentAt = resetPasswordTokenSentAt;
	}

	public boolean getUnconfirmed() {
		return unconfirmed;
	}

	public void setUnconfirmed(boolean unconfirmed) {
		this.unconfirmed = unconfirmed;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(confirmationToken, confirmationTokenSentAt, confirmedAt, createdAt, email, id, password,
				resetPasswordToken, resetPasswordTokenSentAt, role, unconfirmed, updatedAt);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(confirmationToken, other.confirmationToken)
				&& Objects.equals(confirmationTokenSentAt, other.confirmationTokenSentAt)
				&& Objects.equals(confirmedAt, other.confirmedAt) && Objects.equals(createdAt, other.createdAt)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(password, other.password)
				&& Objects.equals(resetPasswordToken, other.resetPasswordToken)
				&& Objects.equals(resetPasswordTokenSentAt, other.resetPasswordTokenSentAt)
				&& Objects.equals(role, other.role) && unconfirmed == other.unconfirmed
				&& Objects.equals(updatedAt, other.updatedAt);
	}
	

}
