package uz.bekhzod0211.tzeffectivemobile.presentation.login.presentation.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.TransitionBuilder.validate
import dagger.hilt.android.AndroidEntryPoint
import uz.bekhzod0211.tzeffectivemobile.R
import uz.bekhzod0211.tzeffectivemobile.databinding.ScreenLoginBinding
import uz.bekhzod0211.tzeffectivemobile.HomeActivity
import uz.bekhzod0211.tzeffectivemobile.presentation.login.presentation.vm.LoginViewModel
import uz.bekhzod0211.tzeffectivemobile.presentation.login.presentation.vm.impl.LoginViewModelImpl
import androidx.core.net.toUri

@AndroidEntryPoint
class LoginScreen : AppCompatActivity() {
    private lateinit var binding: ScreenLoginBinding
    private val vm: LoginViewModel by viewModels<LoginViewModelImpl>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ScreenLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {
            btnLogin.setOnClickListener {
                vm.btnEnterClicked()
        }
            btnLogin.isEnabled = false
            btnVk.setOnClickListener {
                vm.btnVKClicked()
            }

            btnOk.setOnClickListener {
                vm.btnOkClicked()
            }
        }

        vm.openMainScreenLiveData.observe(this){
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        vm.openVkLiveData.observe(this){
            openUrl(" https://vk.com/ ")
        }


        vm.openOKLiveData.observe(this){
            openUrl("https://ok.ru/")
        }
        setupValidation()


    }


    private fun setupValidation() {
        val emailPattern = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")

        // 🔥 Фильтр на латиницу и спецсимволы (без кириллицы)
        binding.etEmail.filters = arrayOf(InputFilter { source, _, _, _, _, _ ->
            if (source.matches(Regex("[а-яА-ЯЁё]+"))) "" else source
        })

        val watcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                validate(emailPattern)
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        }

        binding.etEmail.addTextChangedListener(watcher)
        binding.etPassword.addTextChangedListener(watcher)
    }
    private fun validate(emailPattern: Regex) {
        val email = binding.etEmail.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()

        val isValidEmail = emailPattern.matches(email)
        val isPasswordNotEmpty = password.isNotEmpty()

        binding.btnLogin.isEnabled = isValidEmail && isPasswordNotEmpty

        // 🔥 Визуально (кнопка тусклая)
        binding.btnLogin.alpha = if (binding.btnLogin.isEnabled) 1f else 0.4f
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, url.toUri())
        startActivity(intent)
    }
}
