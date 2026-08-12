/* DevTrack — shared shell + form interactivity */

document.addEventListener('DOMContentLoaded', () => {

  /* -- User dropdown toggle -- */
  const trigger = document.querySelector('.user-menu-trigger');
  const dropdown = document.querySelector('.user-dropdown');

  if (trigger && dropdown) {
    trigger.addEventListener('click', (e) => {
      e.stopPropagation();
      dropdown.classList.toggle('open');
    });
    document.addEventListener('click', () => dropdown.classList.remove('open'));
  }

  /* -- Live avatar initials preview (Developer / Tool forms) -- */
  const nameInput = document.getElementById('fullName');
  const avatar = document.getElementById('identityAvatar');

  if (nameInput && avatar) {
    const palette = ['#034C53', '#547792', '#213448', '#B9862F'];

    const updateAvatar = () => {
      const value = nameInput.value.trim();
      if (!value) {
        avatar.textContent = '?';
        avatar.style.background = 'var(--teal)';
        return;
      }
      const parts = value.split(/\s+/).filter(Boolean);
      const initials = parts.length > 1
        ? (parts[0][0] + parts[parts.length - 1][0])
        : parts[0].slice(0, 2);
      avatar.textContent = initials.toUpperCase();

      let hash = 0;
      for (let i = 0; i < value.length; i++) hash = value.charCodeAt(i) + ((hash << 5) - hash);
      avatar.style.background = palette[Math.abs(hash) % palette.length];
    };

    nameInput.addEventListener('input', updateAvatar);
    updateAvatar();
  }

});
